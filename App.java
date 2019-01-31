import Beans.Client;
import Beans.Event;
import Beans.EventType;
import Loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
   private Client User;
   private EventLogger defaultLogger ;
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
        ApplicationContext cont = new ClassPathXmlApplicationContext("SprConfig.xml");
        App app = (App) cont.getBean("app");

        Event event = (Event) cont.getBean("event");//взятие бина по ИД
        app.LogEvent(EventType.INFO,event,"Some event for user 1 \n");

        event = cont.getBean(Event.class);// взятие бина по имени класса
        app.LogEvent(EventType.ERROR, event, "Some event for user 2 \n");
        event = cont.getBean(Event.class);
        app.LogEvent(null ,event,"Another event for user 3 \n");
        ((ClassPathXmlApplicationContext) cont).close();
    }

}
