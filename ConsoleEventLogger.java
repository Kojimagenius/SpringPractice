public class ConsoleEventLogger implements EventLogger {
    public void LogEvent(Event event){
        System.out.println(event.toString());
    }
}
