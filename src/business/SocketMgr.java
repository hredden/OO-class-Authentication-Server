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
 * This class handles individual socket connections. It utilizes threads to allow
 * for concurrent connections. It opens the IO streams with the client socket
 * and reads in the information.
 */

import java.io.*;
import java.net.*;

public class SocketMgr implements Runnable {
    
    private Socket socket = null;
    
    public SocketMgr(Socket passedSocket){
        this.socket = passedSocket;
    }
    
    @Override
    public void run(){
        try{
            
            //Open IO streams with client
            ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream iStream = new ObjectInputStream(socket.getInputStream());
            
            //Read in data
            String strToAuth = (String)iStream.readObject();
            
            //Authenticate data sent by client
            AuthenticationMgr authenticate = new AuthenticationMgr();
            Boolean isValid = authenticate.authenticate(strToAuth);
            
            //return if data is valid or not
            oStream.writeObject(isValid);
            
            //Close resources
            iStream.close();
            oStream.close();
            socket.close();
        } catch(ClassNotFoundException | IOException e){
            System.out.println(e.getMessage());
        }
        
        
    }//end run
}
