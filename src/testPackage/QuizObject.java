package testPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Squall on 27/01/2015.
 */
public class QuizObject implements Serializable {
    private static final long serialVersionUID = 8854465771377707283L;
    private int id;
    private String name;
    private List<FullQuestion> questions;

    public QuizObject()
    {
        questions = new ArrayList<FullQuestion>();
        name = "";
    }

    public void setupQuiz()
    {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        String question;
        String answer = "";
        int correctAns = 0;
        System.out.println("Enter a quiz with five questions");
        while (count <= 5)
        {
            question = "";
            correctAns = 0;
            System.out.println("Enter Question " + (count) + " Of your Quiz");
            question = sc.nextLine();
            List<Answer> answers = new ArrayList<>();
            for (int i = 1; i < 5; i++)
            {
                answer = "";
                System.out.println("Enter Answer " + i + " for Question " + (count));
                answer = sc.nextLine();
                answers.add(new Answer(answer));
            }
            while(!isValidAnswer(correctAns))
            {
                System.out.println("Enter the number of the answer you entered which was correct");
                String temp = sc.nextLine();
                if (InputValidator.validParse(temp))
                {
                    correctAns = Integer.parseInt(temp);
                }
            }
            questions.add(new FullQuestion(question, answers, correctAns));
            count++;
        }
        System.out.println("Enter Yes to Confirm your Entry or No to re-enter quiz info");
        String confString = sc.next();
        if (confString.equalsIgnoreCase("No"))
        {
            questions.clear();
            setupQuiz();
        }
        else
        {
            setName();
        }
    }

    public boolean isValidAnswer(int num)
    {
        return num > 0 && num < 5;
    }

    public String getName()
    {
        return name;
    }

    private void setName()
    {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Name for your Quiz");
        name = sc.nextLine();
        this.name = name;
    }

    public List<FullQuestion> getQuestions()
    {
        return questions;
    }

    public String toString()
    {
        return "Name: " + name + " Questions: " + questionListToString();
    }

    public String questionListToString()
    {
        String allQuestionsString = "";
        for (int i = 0; i < questions.size(); i++)
        {
            allQuestionsString = allQuestionsString + questions.get(i).toString() + "\n";
        }
        return allQuestionsString;
    }
}
