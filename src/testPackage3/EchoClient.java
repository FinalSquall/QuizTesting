package testPackage3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Squall on 28/01/2015.
 */
public class EchoClient {
    public static void main(String[] args)
    {
        EchoClient ecl = new EchoClient();
        ecl.launch();
    }

    public void launch()
    {
        if (System.getSecurityManager() == null)
        {
            System.setProperty("java.security.policy", "res/client.policy");
            System.setSecurityManager(new SecurityManager());
        }
        try
        {
            Remote service = Naming.lookup("//127.0.0.1:1099/echo");
            EchoService echoService = (EchoService) service;
            String receivedEcho = echoService.echo("Hello");
            System.out.println("Sent Msg to Server");
        }
        catch (MalformedURLException | NotBoundException | RemoteException ex )
        {
            ex.printStackTrace();
        }
    }
}
