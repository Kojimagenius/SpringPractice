package Beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private int id;
    private String msg;
    private Date date;

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
    public Event(Date date, DateFormat df){
        this.date = date; this.df = df;
        this.id = AUTO_ID.getAndIncrement();
    }
}
