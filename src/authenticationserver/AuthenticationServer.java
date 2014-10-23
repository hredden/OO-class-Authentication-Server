/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package authenticationserver;
import business.*;

/**
 *
 * @author Max
 */

/**
 * 
 * Starts an authentication server running
 */
public class AuthenticationServer {

    public static void main(String[] args) {
        ConnectionMgr connectionMgr = new ConnectionMgr();
        connectionMgr.runServer();
    }
    
}
