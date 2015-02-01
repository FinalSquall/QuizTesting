package testPackage;

/**
 * Created by Squall on 31/01/2015.
 */
public class InputValidator {

    public static boolean validParse(String p)
    {
        int validNum = 0;
        for (int i = 0; i < p.length(); i++)
        {
            if (Character.isDigit(p.charAt(i)))
            {
                validNum++;
            }
        }
        return validNum == p.length();
    }

    public static boolean validUserName(String un)
    {
        int valid = 0;
        for (int i = 0; i < un.length(); i++)
        {
            if (Character.isLetter(un.charAt(i)) || Character.isDigit(un.charAt(i)))
            {
                valid++;
            }
        }
        return valid == un.length();
    }

    public static boolean validPlayerName(String un)
    {
        int valid = 0;
        for (int i = 0; i < un.length(); i++)
        {
            if (Character.isLetter(un.charAt(i)))
            {
                valid++;
            }
        }
        return valid == un.length();
    }
}
