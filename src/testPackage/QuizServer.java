package testPackage;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Squall on 27/01/2015.
 */
public class QuizServer extends UnicastRemoteObject implements QuizService, PlayerService {

    private List<QuizObject> quizList;
    private List<Player> players;
    private Score highScore;

    public QuizServer() throws RemoteException
    {
        quizList = new ArrayList<QuizObject>();
        players = new ArrayList<Player>();
        this.highScore = null;
        if (fileExists())
        {
                readQuizList();
        }
        System.out.println("Quiz Server Running");
        Runtime.getRuntime().addShutdownHook(flushHook());
    }

    public QuizObject echoQuiz(QuizObject qo) {
        quizList.add(qo);
        quizInfo();
        return qo;
    }

    private Thread flushHook()
    {
        return new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                storeQuizList();
            }
        });
    }

    public String[] showQuizChoices() throws RemoteException
    {
        System.out.println("Sent quiz names to Player: ");
        String[] quizNames = new String[quizList.size()];
        for (int i = 0; i < quizList.size(); i++)
        {
            quizNames[i] = quizList.get(i).getName();
        }
        return quizNames;
    }

    public String getQuestion() throws RemoteException
    {
        System.out.println("Sent Question to Player");
        return quizList.get(0).getQuestions().get(0).getQuestion().getQuestion();
    }

    public boolean isExistingId(String userName)
    {
        boolean exists = false;
        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).getUserName().equals(userName))
            {
                exists = true;
            }
        }
        return exists;
    }

    public String testPlayerEntry()
    {
        return "Name: " + players.get(players.size()-1).getName() + "\nUN: " + players.get(players.size()-1).getUserName();
    }

    public void quizInfo()
    {
        System.out.println("Added quiz titled \"" + quizList.get(quizList.size()-1).getName() + "\" to server");
        System.out.println("The server now has " + quizList.size() + " quizzes stored");
    }

    public void storeQuizList()
    {
        File file = new File("QuizList.txt");
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ){
            oos.writeObject(quizList);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void readQuizList()
    {
        File file = new File("QuizList.txt");
        try (
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ){
            quizList = (List<QuizObject>) ois.readObject();
        }
        catch (ClassNotFoundException | IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void fetchPlayer(Player aPlayer)
    {
        players.add(aPlayer);
    }

    public boolean fileExists()
    {
        File file = new File("QuizList.txt");
        return file.exists();
    }

}
