package testPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Squall on 30/01/2015.
 */
public interface PlayerService extends Remote {
    String[] showQuizChoices() throws RemoteException;
    String getQuestion() throws RemoteException;
}
