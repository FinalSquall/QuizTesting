package testPackage;

import java.io.Serializable;

/**
 * Created by Squall on 27/01/2015.
 */
public class Question implements Serializable {
    private static final long serialVersionUID = 2373937640224150708L;
    private String question;

    public Question(String q)
    {
        this.question = q;
    }

    public String getQuestion()
    {
        return question;
    }

    public String toString()
    {
        return "Question: " + question;
    }
}
