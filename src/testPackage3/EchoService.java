package testPackage3;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Squall on 28/01/2015.
 */
public interface EchoService extends Remote {
    public String echo(String s) throws RemoteException;
}
