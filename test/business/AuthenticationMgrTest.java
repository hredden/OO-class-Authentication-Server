/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max
 */
public class AuthenticationMgrTest {
    
    public AuthenticationMgrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of authenticate method, of class AuthenticationMgr.
     */
    @Test
    public void testAuthenticate() {
        System.out.println("authenticate");
        //Test false inpuf
        String falseStrToAuthenticate = "";
        AuthenticationMgr instance = new AuthenticationMgr();
        boolean expResult = false;
        boolean result = instance.authenticate(falseStrToAuthenticate);
        assertEquals(expResult, result);
        
        //Test correct input
        String correctStr = "regis/student";
        expResult = true;
        result = instance.authenticate(correctStr);
        assertEquals(expResult, result);
        
    }
    
}
