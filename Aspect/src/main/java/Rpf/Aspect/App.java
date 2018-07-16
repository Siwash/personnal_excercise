package Rpf.Aspect;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
        //init spring-IOC container
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        Login login= context.getBean(Login.class);
        InetAddress id=InetAddress.getLocalHost();
        System.err.println(id.getHostAddress()+"+++++"+id.getHostName());
        System.out.println(login.doLogin(0)+"mian");
    }
}
