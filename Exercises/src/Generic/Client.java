package Generic;

public class Client {
    String name;

    public Client(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Client{name='"+ name+"'}";
    }
}
