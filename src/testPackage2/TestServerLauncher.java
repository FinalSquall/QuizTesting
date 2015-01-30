package testPackage2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Squall on 27/01/2015.
 */
public class TestServerLauncher {

    public static void main(String[] args)
    {
        TestServerLauncher tsl = new TestServerLauncher();
        tsl.registerServer();
        System.out.println("TestServer Running...");
    }

    public void registerServer()
    {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("echo", new TestServer());
        }
        catch (RemoteException ex)
        {
            ex.printStackTrace();
        }
    }
}
