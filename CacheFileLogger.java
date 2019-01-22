import java.util.List;

public class CacheFileLogger extends FileEventLogger {
    private int   cacheSize ;
    private List<Event> cache;


    CacheFileLogger(String fileName, int cacheSize){
        super(fileName);
        this.cacheSize = cacheSize;
        cache = null;
    }
    public void LogEvent(Event ev) {
        cache.add(ev);
        if(cache.size() == cacheSize){
        writeEvents();
        cache.clear();
        }

    }
    public void writeEvents(){
        for (Event ev:cache) {super.LogEvent(ev);
        }
    }
    public void destroy(){
        if(!cache.isEmpty())
            writeEvents();
    }
}
