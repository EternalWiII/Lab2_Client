package com.mycompany.lab2_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectInputMessage implements Runnable{
    private Socket serverConnect;
    private InputStream inputStreamServer;
    
    public ConnectInputMessage() {
        try{
          serverConnect = new Socket("localhost", 8887);
          inputStreamServer = serverConnect.getInputStream();
        } catch(IOException ex) {
            
        }
    }
    
    public InputStream getInputStreamServer(){
        return inputStreamServer;
    }
    
    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMessage;
        
        while(true) {
            try{
                serverMessage = in.readLine();
                if(serverMessage != null){
                    System.out.println(serverMessage + '\n');
                    break;
                }
            } catch(IOException ex){
                
            }
        }
        
        PrintWriter out = null;
        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));
        
        String userMessage = null;
        
        while(true) {
            System.out.println("Enter message: ");
            try{
                userMessage = inputUser.readLine();
                out = new PrintWriter(serverConnect.getOutputStream(), true);
                out.println(userMessage);
            } catch(IOException e){
                
            }
        }
    }
}
