import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client User;
    EventLogger logger;


    public App(Client usr, EventLogger lg){
        User = usr;
        logger = lg;
    }
    public App(){}
    private void LogEvent(Event  event, String msg)
    {
        String message = msg.replaceAll(Integer.toString(User.getID()), User.getName());
        event.setMsg(message);
        logger.LogEvent(event);
    }
    public static void main(String[] args) {
        ApplicationContext cont = new ClassPathXmlApplicationContext("SprConfig.xml");
        App app = (App) cont.getBean("app");

        Event event = (Event) cont.getBean("event");//взятие бина по ИД
        app.LogEvent(event,"Some event for user 1");

        event = cont.getBean(Event.class);// взятие бина по имени класса
        app.LogEvent(event, "Some event for user 2");
        ((ClassPathXmlApplicationContext) cont).close();
    }

}
