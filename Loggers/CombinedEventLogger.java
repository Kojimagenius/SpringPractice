package Loggers;

import Beans.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;



@Component
public class CombinedEventLogger implements EventLogger {

    @Resource(name = "combinedLoggers")
 private static Collection<EventLogger> loggers;
@Override
public void LogEvent(Event ev) {
for (EventLogger eventLogger : loggers)eventLogger.LogEvent(ev);
    }
}
