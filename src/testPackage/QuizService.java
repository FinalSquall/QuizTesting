package testPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Squall on 27/01/2015.
 */
public interface QuizService extends Remote {
    QuizObject echoQuiz(QuizObject qo) throws RemoteException;
}
