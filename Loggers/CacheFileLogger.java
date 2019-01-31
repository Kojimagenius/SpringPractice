package Loggers;

import Beans.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class CacheFileLogger extends FileEventLogger {

    @Value("$cache.size:5")
    private int   cacheSize ;
    private List<Event> cache;


    CacheFileLogger(String fileName, int cacheSize){
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }
    @Override
    public void LogEvent(Event ev) {
        cache.add(ev);
        if(cache.size() == cacheSize){
        writeEvents();
        cache.clear();
        }

    }
    public void writeEvents(){
        for (Event ev:cache) {cache.stream().forEach(super::LogEvent);
        }
    }
    @PostConstruct
    public void initCache(){
        this.cache = new ArrayList<Event>(cacheSize);
    }
    @PreDestroy
    public void destroy(){
        if(!cache.isEmpty())
            writeEvents();
    }

}
