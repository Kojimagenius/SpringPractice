public class Client {
    int ID;
    String Name;
    String greeting;

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }
public Client(int id, String name){
        ID=id;
        Name = name;
}
public Client(){}
}
