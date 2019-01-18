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
    private void LogEvent(Event  ev)
    {
        //String msg = message.replaceAll(Integer.toString(User.getID()), User.getName());
    logger.LogEvent(ev);
    }
    public static void main(String[] args) {
        ApplicationContext cont = new ClassPathXmlApplicationContext("SprConfig.xml");
        App app = (App) cont.getBean("app");
        //app.LogEvent("Some event for user 1");
        System.out.println();
    }

}
