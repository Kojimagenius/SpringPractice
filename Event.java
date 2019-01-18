import java.text.DateFormat;
import java.util.Date;

public class Event {
    int id;
    String msg;
    Date date;
    DateFormat df;


    @Override
    public String toString(){
        return msg +" for user with id: " + id + " on date " + df.format(date);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
    public Event(Date date, DateFormat df){
        this.date = date; this.df = df;
    }
}
