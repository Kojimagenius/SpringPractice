import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public void Init() throws IOException{
        this.file = new File(fileName);
        file.canWrite();
    }
    FileEventLogger(String NameOfFile){
        fileName = NameOfFile;

    }
    public void LogEvent(Event ev){
        try{FileUtils.writeStringToFile(file,ev.toString(), true);}
        catch (IOException e){
            System.err.println("File error");e.printStackTrace();
        }
    }
}
