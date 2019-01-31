package Loggers;

import Beans.Event;
import org.springframework.stereotype.Component;

@Component
public class ConsoleEventLogger implements EventLogger {
    public void LogEvent(Event event){
        System.out.println(event.toString());
    }
}
