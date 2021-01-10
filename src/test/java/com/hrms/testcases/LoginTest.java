package com.hrms.testcases;

import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import org.testng.annotations.Test;

public class LoginTest extends CommonMethods {

    @Test
    public void adminLogin(){
        LoginPage login=new LoginPage ();
        sendText ( login.username, ConfigsReader.getPropertyValue ( "username" ) );
        sendText ( login.password,ConfigsReader.getPropertyValue ( "password" ) );
        click ( login.loginBtn );

    }
}
