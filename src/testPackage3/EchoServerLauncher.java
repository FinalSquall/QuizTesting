package testPackage3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Squall on 28/01/2015.
 */
public class EchoServerLauncher {
    public static void main(String[] args)
    {
        EchoServerLauncher esl = new EchoServerLauncher();
        esl.launch();
    }

    public void launch()
    {
        if (System.getSecurityManager() == null)
        {
            System.setProperty("java.security.policy", "res/server.policy");
            System.setSecurityManager(new SecurityManager());
        }
        try
        {
            LocateRegistry.createRegistry(1099);
            EchoServer server = new EchoServer();
            String registryHost = "//localhost/";
            String serviceName = "echo";
            Naming.rebind(registryHost + serviceName, server);
        }
        catch (MalformedURLException ex)
        {
            ex.printStackTrace();
        }
        catch (RemoteException ex)
        {
            ex.printStackTrace();
        }
    }
}
