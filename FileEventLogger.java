import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    String fileName;
    File file;

    public void Init() throws IOException{
        this.file = new File(fileName);
        file.canWrite();
    }
    public void LogEvent(Event ev){
        try{FileUtils.writeStringToFile(file,ev.toString(), true);}
        catch (IOException e){
            System.err.println("File error");e.printStackTrace();
        }
    }
}
