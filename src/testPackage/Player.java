package testPackage;

import java.io.Serializable;

/**
 * Created by Squall on 31/01/2015.
 */
public class Player implements Serializable {
    private static final long serialVersionUID = -1335761905213928563L;
    private String userName;
    private String name;
    private Score highestPersonal;

    public Player(String userName, String name)
    {
        this.userName = userName;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String getUserName()
    {
        return userName;
    }
}
