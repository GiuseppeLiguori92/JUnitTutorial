package com.giuseppeliguori.junittutorial;

/**
 * Created by Giuseppe on 06/11/2016.
 */
public class Utils {

    private static Utils instance = null;

    /**
     * Use synchronize to implement multithreading
     * @return
     */
    public static Utils getInstance() {
        if (instance == null )
        {
            instance = new Utils();
        }
        return instance;
    }


    /**
     * Stupid implementation used only to try the tests, i have to use simply a matcher
     * @param ipAddress
     * @return
     */
    public boolean isIpFormatted( String ipAddress )
    {

        if ( ipAddress == null )
            return false;

        if ( ipAddress.isEmpty() || ipAddress.length() == 0)
            return false;

        if ( ipAddress.length() < 6 || ipAddress.length() > 15 )
            return false;

        int dots = 0 ;

        for (int i = 0; i < ipAddress.length(); i++) {
            if (ipAddress.charAt(i) == '.' )
            {
                dots++;
            }
        }

        if ( dots != 3 )
            return false;

        String numbersString[] = ipAddress.split("\\.");

        if ( numbersString == null )
            return false;

        if ( numbersString.length != 4 )
            return false;

        int n ;

        for (String number : numbersString ) {

            try{
                n = Integer.parseInt(number);
            }catch( NumberFormatException e ){
                return false;
            }

            if ( n < 0 || n > 255 )
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Stupid implementation used only to try the tests, i have to use simply a matcher
     * https://en.wikipedia.org/wiki/Email_address
     * @param email
     * @return
     */
    public boolean isEmailFormatted( String email )
    {

        if ( email == null )
            return false;

        if ( email.length() == 0 || email.isEmpty() )
            return false;

        if ( email.length() < 3 || email.length() > 254)
            return false;

        if ( !email.contains("@") )
            return false;

        int ats = 0 ;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@' )
                ats++;
        }

        if ( email.split("@")[0].length() > 64 )
            return false;

        if ( email.split("@")[0].charAt(0) == '.' )
            return false;

        if ( email.split("@")[0].charAt(email.split("@")[0].length() - 1) == '.' )
            return false;

        if ( email.split("@")[0].contains(".."))
            return false;

        if ( ats != 1 )
            return false;

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if ( !email.matches(emailPattern) )
            return false;

        return true;
    }
}
