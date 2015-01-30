package testPackage2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Squall on 27/01/2015.
 */
public class TestServer extends UnicastRemoteObject implements TestService {

    public TestServer() throws RemoteException
    {

    }

    @Override
    public int echoNumber(int n)
    {
        System.out.println("Sending number " + n + " to client");
        return n;
    }
}
