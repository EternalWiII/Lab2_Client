package com.mycompany.lab2_client;

public class Lab2_Client {

    public static void main(String[] args) {
        ConnectInputMessage connectWithServer = new ConnectInputMessage();
        Thread tConnectInputMessage = new Thread(connectWithServer);
        tConnectInputMessage.start();
        
        RecieveMessageFromServer recieveMessage = new RecieveMessageFromServer(connectWithServer.getInputStreamServer());
        Thread tRecieveMessage = new Thread(recieveMessage);
        tRecieveMessage.start();
    }
}
