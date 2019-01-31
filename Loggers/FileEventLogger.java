package Loggers;

import Beans.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;



@Component
public class FileEventLogger implements EventLogger {

    @Value("${target/log.txt}")
    private String fileName;
    private File file;

    @PostConstruct
    public void Init() throws IOException{
        this.file = new File(fileName);
        file.canWrite();
    }
    FileEventLogger(String NameOfFile){
        fileName = NameOfFile;

    }
    FileEventLogger(){}


    @Override
    public void LogEvent(Event ev){
        try{FileUtils.writeStringToFile(file,ev.toString(), true);}
        catch (IOException e){
            System.err.println("File error");e.printStackTrace();
        }
    }
}
