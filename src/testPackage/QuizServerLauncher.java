package testPackage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Squall on 28/01/2015.
 */
public class QuizServerLauncher {
    public static void main(String[] args)
    {
        QuizServerLauncher qsl = new QuizServerLauncher();
        qsl.launch();
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
            QuizServer server = new QuizServer();
            String registryHost = "//192.168.1.102/";
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
