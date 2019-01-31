package Config;

import Beans.EventType;
import Loggers.EventLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

@Configuration
public class LoggerConfig {


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Resource(name = "Loggers.ConsoleEventLogger")
    private EventLogger consoleEventLogger;
    @Resource(name = "FileEventLogger")
    private  EventLogger fileEventLogger;
    @Resource(name = "CacheFileLogger")
    private EventLogger CacheLogger;
    @Resource(name = "CombinedEventLogger")
    private EventLogger combinedEventLogger;


    @Bean
    public Collection<EventLogger> combinedLoggers(){
        Collection<EventLogger> loggers = new ArrayList<EventLogger>(2);
        ((ArrayList<EventLogger>) loggers).add(consoleEventLogger);
        loggers.add(fileEventLogger);
        return loggers;
    }


    @Bean
    public Map<EventType, EventLogger> loggerMap(){
        Map<EventType,EventLogger> map = new EnumMap<EventType, EventLogger>(EventType.class);
        map.put(EventType.INFO, consoleEventLogger);
        map.put(EventType.ERROR, combinedEventLogger);
        return map;
    }



    @Bean
    public EventLogger defaultLogger (){
        return CacheLogger;
    }
    }
