/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

/**
 *
 * @author Max
 */

/**
 * This is the listener for the server. It listens for sockets to request the
 * services of the server and creates a new thread to implement SocketMgr so that 
 * it can return to listening.
 */

import java.io.IOException;
import java.net.*;

public class ConnectionMgr {
    private int portNum = 19999;
    private int queueNum = 100;
    ServerSocket server = null;
    Socket socket = null;
    boolean exit = false;
    
    public void runServer(){
        
        try{
            server = new ServerSocket(portNum, queueNum);
            while(!exit){
                System.out.println("Waiting for connection on port " + portNum);
                socket = server.accept();
                //Hand over socket to socket manager
                SocketMgr newSocket = new SocketMgr(socket);
                Thread thread = new Thread(newSocket);
                thread.start();
                                                
            }//end while
        } catch(IOException e){
            System.out.println(e.getMessage());
        } 
        
    }//end runServer
    
    public void turnOff(){
        exit = true;
    }//end turn off
    
    public void turnOn(){
        this.runServer();
    }
    
}//End class
