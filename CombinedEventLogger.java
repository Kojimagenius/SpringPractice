import java.util.Collection;

public class CombinedEventLogger implements EventLogger {




 private final Collection<EventLogger> loggers;


public CombinedEventLogger(Collection<EventLogger> loggers){
    super();
    this.loggers=loggers;
}



public void LogEvent(Event ev) {
for (EventLogger eventLogger : loggers)eventLogger.LogEvent(ev);
    }
}
