public class Client {
    String name;
    Integer number;

    public Client(String name) {
        this.name = name;
    }


    public Client(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }
}
