package Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope("prototype")
public class Event {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);


    private int id;
    private String msg;
    @Autowired
    @Qualifier("getDate")
    private Date date;

    @Autowired
    private DateFormat df;


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
    public Event (){
        this.id = AUTO_ID.getAndIncrement();
    }

    public Event(Date date, DateFormat df){
        this.date = date; this.df = df;
        this.id = AUTO_ID.getAndIncrement();
    }
}
