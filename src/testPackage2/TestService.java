package testPackage2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Squall on 27/01/2015.
 */
public interface TestService extends Remote {

    public int echoNumber(int n) throws RemoteException;
}
