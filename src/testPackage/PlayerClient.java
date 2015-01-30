package testPackage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Arrays;

/**
 * Created by Squall on 30/01/2015.
 */
public class PlayerClient {

    public static void main(String[] args)
    {
        PlayerClient pcl = new PlayerClient();
        pcl.setupPlayerQuiz();
    }

    public void setupPlayerQuiz()
    {
        if (System.getSecurityManager() == null)
        {
            System.setProperty("java.security.policy", "res/player.policy");
            System.setSecurityManager(new SecurityManager());
        }
        try
        {
            Remote service = Naming.lookup("//127.0.0.1:1099/echo");
            PlayerService plService = (PlayerService) service;
            Arrays.stream(plService.showQuizChoices()).forEach((name) -> System.out.println(name));
            System.out.println(plService.getQuestion());
        }
        catch (MalformedURLException | NotBoundException | RemoteException ex )
        {
            ex.printStackTrace();
        }
    }
}
