package testPackage2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Squall on 27/01/2015.
 */
public class TestClient {
    public static void main(String[] args)
    {
        TestClient tcl = new TestClient();
        tcl.serverLink(4);
    }

    public void serverLink(int n)
    {
        try
        {
            Registry reg = LocateRegistry.getRegistry("localhost", 0);
            TestService t = (TestService) reg.lookup("echo");
            int newNum = t.echoNumber(n);
            System.out.println("Obtained: " + newNum + " From the Client.");
        }
        catch (RemoteException | NotBoundException ex)
        {
            ex.printStackTrace();
        }
    }
}
