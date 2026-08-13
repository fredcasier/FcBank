package main;

import java.util.ArrayList;

import main.components.Client;

// 1.1.2 Creation of main class for tests
public class Main {
    static ArrayList<Client> clients;
    public static void main(String[] args) {
        Main.clients = generateClients(4);
        displayClient(Main.clients);
    }

    public static ArrayList<Client> generateClients (int number) {
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            Client newClient = new Client("name"+i, "firstName"+i);
            clients.add(newClient);
        }
        return clients;
    }

    public static void displayClient(ArrayList<Client> clients) {
        for (Client client : clients) {
            System.out.println(client.toString());
        }
    }
}
