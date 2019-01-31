import Beans.Client;
import Beans.Event;
import Beans.EventType;
import Config.LoggerConfig;
import Config.SprConfig;
import Loggers.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


@Service("app")
public class App {
    @Autowired
   private Client User;
    @Resource(name = "defaultLogger")
    private EventLogger defaultLogger ;
    @Resource(name = "loggerMap")
    private Map<EventType,EventLogger> loggers;


    public App(Client usr, EventLogger lg, Map<EventType,EventLogger> loggers){
        User = usr;
        defaultLogger = lg;
        this.loggers = loggers;
    }
    public App(){}
    private void LogEvent(EventType eventType, Event event, String msg)
    {
        String message = msg.replaceAll(Integer.toString(User.getID()), User.getName());
        event.setMsg(message);
        EventLogger evLogger = loggers.get(eventType);
        if(evLogger == null)evLogger = defaultLogger;
        evLogger.LogEvent(event);
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("Config","Beans","Loggers");
        ctx.register(App.class);
        ctx.refresh();
        App app = (App)ctx.getBean("app");
        Client client = ctx.getBean(Client.class);
        System.out.println("Client Says: " + client.getGreeting());
        Event event = ctx.getBean(Event.class);
        app.LogEvent(EventType.INFO, event, "Some event for 1");

        event = ctx.getBean(Event.class);
        app.LogEvent(EventType.ERROR, event, "Some event for 2");

        event = ctx.getBean(Event.class);
        app.LogEvent(null, event, "Some event for 3");

        ctx.close();
        //Event event = (Event) cont.getBean("event");//взятие бина по ИД
        //app.LogEvent(EventType.INFO,event,"Some event for user 1 \n");

 //       event = cont.getBean(Event.class);// взятие бина по имени класса
    }

}
