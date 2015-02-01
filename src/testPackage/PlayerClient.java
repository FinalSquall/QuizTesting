package testPackage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Squall on 30/01/2015.
 */
public class PlayerClient {

    Remote service;
    PlayerService plService;

    public PlayerClient()
    {
        if (System.getSecurityManager() == null)
        {
            System.setProperty("java.security.policy", "res/player.policy");
            System.setSecurityManager(new SecurityManager());
        }
        try {
            service = Naming.lookup("//127.0.0.1:1099/echo");
            plService = (PlayerService) service;
        }
        catch (MalformedURLException | NotBoundException | RemoteException ex )
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        PlayerClient pcl = new PlayerClient();
        try {
            pcl.setupPlayer();
            pcl.setupPlayerQuiz();
        }
        catch (RemoteException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setupPlayer() throws RemoteException
    {
        boolean done = false;
        Scanner sc = new Scanner(System.in);
        String userName = "";
        System.out.println("Enter a Unique UserName as a String Containing a-z and/or 0-9");
        while (!done)
        {
            userName = sc.nextLine();
            if (!(InputValidator.validUserName(userName)))
            {
                System.out.println("Invalid Input Entered, You must Enter a Valid Username With a-z or 0-9.");
            }
            else
            {

                if (InputValidator.validUserName(userName))
                {
                    if (!(plService.isExistingId((userName))))
                    {
                        done = true;
                    }
                    else
                    {
                        System.out.println("You must Enter a Unique UserName!");
                    }
                }
            }
        }
        done = false;
        String playerName = "";
        System.out.println("Enter your name");
        while (!done)
        {
            playerName = sc.nextLine();
            if (InputValidator.validPlayerName(playerName))
            {
                done = true;
            }
            else
            {
                System.out.println("Invalid name entered, enter a valid string of a-z characters");
            }
        }
        plService.fetchPlayer(new Player(userName, playerName));
    }

    public void setupPlayerQuiz() throws RemoteException
    {
            Arrays.stream(plService.showQuizChoices()).forEach((name) -> System.out.println(name));
        System.out.println(plService.testPlayerEntry());
    }
}
