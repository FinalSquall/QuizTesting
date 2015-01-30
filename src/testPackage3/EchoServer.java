package testPackage3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Squall on 28/01/2015.
 */
public class EchoServer extends UnicastRemoteObject implements EchoService {

    public EchoServer() throws RemoteException {

    }

    @Override
    public String echo(String s)
    {
        System.out.println("Replied to some client saying: " + s);
        return s;
    }
}
