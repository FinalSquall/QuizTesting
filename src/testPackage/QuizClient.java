package testPackage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Squall on 27/01/2015.
 */
public class QuizClient {

    public QuizClient()
    {

    }

    public static void main(String[] args)
    {
        QuizClient qc = new QuizClient();
        qc.setupClient();
    }

    public void setupClient()
    {
        if (System.getSecurityManager() == null)
        {
            System.setProperty("java.security.policy", "res/client.policy");
            System.setSecurityManager(new SecurityManager());
        }
        try
        {
            Remote service = Naming.lookup("//127.0.0.1:1099/echo");
            QuizService quizService = (QuizService) service;
            QuizObject qo = new QuizObject();
            qo.setupQuiz();
            quizService.echoQuiz(qo);
            System.out.println("Sent Quiz to Server");
        }
        catch (MalformedURLException | NotBoundException | RemoteException ex )
        {
            ex.printStackTrace();
        }
    }
}
