package testPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Squall on 29/01/2015.
 */
public class FullQuestion implements Serializable {
    private Question question;
    private List<Answer> answerSet;
    private int correctAnswerIndex;

    public FullQuestion(String q, List<Answer> answers, int correctAns)
    {
        this.answerSet = new ArrayList<Answer>();
        question = new Question(q);
        answerSet = answers;
        this.correctAnswerIndex = correctAns;
    }

    public Answer correctAnswer()
    {
        return answerSet.get(correctAnswerIndex-1);
    }

    public Question getQuestion()
    {
        return question;
    }

    public List<Answer> getAnswerSet()
    {
        return answerSet;
    }

    public int getCorrectAnswerIndex()
    {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int index)
    {
        correctAnswerIndex = index;
    }

}
