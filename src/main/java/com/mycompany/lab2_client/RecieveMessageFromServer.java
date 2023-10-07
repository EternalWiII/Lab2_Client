package com.mycompany.lab2_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RecieveMessageFromServer implements Runnable {
    private InputStream inputStreamServer;

    public RecieveMessageFromServer(InputStream inputStreamServer) {
        this.inputStreamServer = inputStreamServer;
    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMessage;
        
        while(true) {
            try{
                serverMessage = in.readLine();
                if(serverMessage != null){
                    System.out.println("serverMessage" + "\nEnter message: ");
                    break;
                }
            } catch(IOException ex){
                
            }
        }
    }    
}
