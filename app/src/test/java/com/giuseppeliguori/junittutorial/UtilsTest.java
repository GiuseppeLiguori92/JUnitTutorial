package com.giuseppeliguori.junittutorial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
/**
 * Created by Giuseppe on 06/11/2016.
 */

@RunWith(JUnit4.class)
public class UtilsTest {

    @BeforeClass
    public static void before()
    {
        System.out.println("Starting the test\n");
    }

    @AfterClass
    public static void after()
    {
        System.out.println("Ended the test\n");
    }

    @Test
    public void isSingleton_VerifySingularityOfObject()
    {
        assertEquals(Utils.getInstance(), Utils.getInstance() );
    }

    @Test
    public void isIpFormatted_whenIpIsNull()
    {
        String ip = null;

        assertFalse(Utils.getInstance().isIpFormatted(ip));

    }

    @Test
    public void isIpFormatted_whenIpIsEmptyOrLenght0()
    {
        String ip = "";

        assertFalse(Utils.getInstance().isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpLengthIsLessThan6()
    {
        String ip = "1.1.1.";

        assertFalse(Utils.getInstance().isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpLengthIsLessMoreThan15()
    {
        String ip = "255.255.255.2553";

        assertFalse(Utils.getInstance().isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpHasNot3Dots()
    {
        String ip = "255.255.255233";

        assertFalse(Utils.getInstance().isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpHasNotNumbersFrom0to255()
    {
        String ip = "255.255.25.400";

        assertFalse(Utils.getInstance().isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpStartsWithDot()
    {
        String ip = ".255.255.25.1";

        assertFalse(Utils.getInstance().isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpIsAllDots()
    {
        String ip = "...";

        assertFalse(Utils.getInstance().isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpEndsWithDot()
    {
        String ip = "255.255.1.1.";

        assertFalse(Utils.getInstance().isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpContainsOtherCharsFurtherThanDotAndNumber()
    {
        String ip = "255.&ˆ&.##).(&";

        assertFalse(Utils.getInstance().isIpFormatted(ip));

        ip = "±1§._32?.312,.2321";

        assertFalse(Utils.getInstance().isIpFormatted(ip));
    }


    @Test
    public void isIpFormatted_whenIpIsOk()
    {
        String ip = "192.168.12.123";

        assertTrue(Utils.getInstance().isIpFormatted(ip));

        ip = "0.0.0.0";

        assertTrue(Utils.getInstance().isIpFormatted(ip));

        ip = "255.255.255.255";

        assertTrue(Utils.getInstance().isIpFormatted(ip));

        ip = "192.168.2.120";

        assertTrue(Utils.getInstance().isIpFormatted(ip));

    }

    @Test
    public void isEmailFormatted_whenEmailIsNull()
    {
        String email = null ;
        
        assertFalse(Utils.getInstance().isEmailFormatted(email));
    }

    @Test
    public void isEmailFormatted_whenEmailIsEmptyOrLength0()
    {
        String email = "" ;

        assertFalse(Utils.getInstance().isEmailFormatted(email));
    }
    
    @Test
    public void isEmailFormatted_whenEmailLengthLessThan255()
    {
        String email = "" ;

        for (int i = 0 ; i < 300 ; i++)
            email+=" ";

        assertFalse(Utils.getInstance().isEmailFormatted(email));
    }
    
    @Test
    public void isEmailFormatted_whenEmailNotContainsAt()
    {

        String email = "emailemail.email" ;

        assertFalse(Utils.getInstance().isEmailFormatted(email));
    }
    
    @Test
    public void isEmailFormatted_whenEmailContainsMoreAt()
    {

        String email = "email@@email.email" ;

        assertFalse(Utils.getInstance().isEmailFormatted(email));

    }

    @Test
    public void isEmailFormatted_whenEmailContainsDots()
    {
        String email = "e.m.a.i.l@email.email" ;

        assertTrue(Utils.getInstance().isEmailFormatted(email));
    }

    @Test
    public void isEmailFormatted_whenEmailContainsSpecialChars()
    {

        String email = "*#&)!&#()&em.ail@email..email";

        assertFalse(Utils.getInstance().isEmailFormatted(email));

    }

    @Test
    public void isEmailFormatted_whenEmailContainsSpaces()
    {

        String email = "em a il@email.i";

        assertFalse(Utils.getInstance().isEmailFormatted(email));

    }

    @Test
    public void isEmailFormatted_whenEmailLocalPartLengthIsMoreThan64()
    {

        String email = "" ;

        for (int i = 0 ; i < 100 ; i++)
            email+="a";

        email+="@email.it";
        assertFalse(Utils.getInstance().isEmailFormatted(email));

    }

    @Test
    public void isEmailFormatted_whenEmailLocalPartStartsWithDot()
    {

        String email = ".email@email.email";

        assertFalse(Utils.getInstance().isEmailFormatted(email));

    }

    @Test
    public void isEmailFormatted_whenEmailLocalPartContainsMoreDotsConsecutively()
    {

        String email = "em..ail@email.email";

        assertFalse(Utils.getInstance().isEmailFormatted(email));

    }

    @Test
    public void isEmailFormatted_whenEmailLocalPartEndsWithDot()
    {

        String email = "email.@email.email";

        assertFalse(Utils.getInstance().isEmailFormatted(email));

    }

    @Test
    public void isEmailFormatted_whenEmailIsOk()
    {

        String email = "email@email.email";

        assertTrue(Utils.getInstance().isEmailFormatted(email));

    }
}
