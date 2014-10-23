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
 * 
 * This class deals with the authentication of the login information provided
 * by the client
 */

public class AuthenticationMgr {
    private String validUser = "regis/student";
    
    public boolean authenticate(String strToAuthenticate){
        return (validUser.equals(strToAuthenticate));
    }
    
    
}//End class
