package testPackage;

import java.io.Serializable;

/**
 * Created by Squall on 29/01/2015.
 */
public class Answer implements Serializable {
    private static final long serialVersionUID = 5713037108281620664L;
    private String answer;

    public Answer(String ans)
    {
        answer = ans;
    }

    public String getAnswer()
    {
        return answer;
    }

    public String toString()
    {
        return "Answer: " + answer;
    }
}
