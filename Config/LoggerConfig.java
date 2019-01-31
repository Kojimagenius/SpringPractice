package Config;

import Beans.EventType;
import Loggers.CacheFileLogger;
import Loggers.EventLogger;


import Loggers.FileEventLogger;
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
    @Resource(name = "ConsoleEventLogger")
    private EventLogger ConsoleEventLogger;
    @Resource(name = "FileEventLogger")
    private  EventLogger FileEventLogger;
    @Resource(name = "CacheFileLogger")
    private EventLogger CacheLogger;
    @Resource(name = "CombinedEventLogger")
    private EventLogger CombinedEventLogger;


    @Bean
    public Collection<EventLogger> combinedLoggers(){
        Collection<EventLogger> loggers = new ArrayList<EventLogger>(2);
        loggers.add(ConsoleEventLogger);
        loggers.add(FileEventLogger);
        return loggers;
    }


    @Bean
    public Map<EventType, EventLogger> loggerMap(){
        Map<EventType,EventLogger> map = new EnumMap<EventType, EventLogger>(EventType.class);
        map.put(EventType.INFO, ConsoleEventLogger);
        map.put(EventType.ERROR, CombinedEventLogger);
        return map;
    }



    @Bean
    public EventLogger defaultLogger (){
        return CacheLogger;
    }
    }
