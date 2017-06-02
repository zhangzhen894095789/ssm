package me.zhangzhen.javaEmail.javaxMail;
/**   
 * 邮箱认证
 */ 
import javax.mail.*;   

public class MyEmailAuthenticator extends Authenticator{   
    String userName=null;   
    String password=null;   
        
    public MyEmailAuthenticator(){   
    }   
    public MyEmailAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }   
}   
