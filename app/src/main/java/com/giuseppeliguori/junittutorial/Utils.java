package com.giuseppeliguori.junittutorial;

/**
 * Created by Giuseppe on 06/11/2016.
 */
public class Utils {

    private static Utils instance = null;

    public Utils()
    {

    }

    /**
     * Use syncronized to implement multithreading
     * @return
     */
    public static Utils getInstance() {
        if (instance == null )
        {
            instance = new Utils();
        }
        return instance;
    }



    public static boolean isIpFormatted( String ipAddress )
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
}
