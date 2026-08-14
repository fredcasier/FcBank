package main.components;

 // 1.1.1 Creation of the Client class
public class Client {
    private String name;
    private String firstName;
    private Integer clientNumber;

    static private Integer clientsCount = 1;

    public Client(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
        this.clientNumber = Client.clientsCount;
        Client.clientsCount++;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }


    @Override
    public String toString() {
        return this.clientNumber + " " + this.name + " " + this.firstName;
    }
}
