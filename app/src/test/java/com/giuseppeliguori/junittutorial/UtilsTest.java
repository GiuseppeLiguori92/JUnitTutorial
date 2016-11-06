package com.giuseppeliguori.junittutorial;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Giuseppe on 06/11/2016.
 */
public class UtilsTest {

    @Test
    public void isSingleton_VerifySingularityOfObject()
    {
        assertEquals(Utils.getInstance(), Utils.getInstance() );
    }

    @Test
    public void isIpFormatted_whenIpIsNull()
    {
        String ip = null;

        assertFalse(Utils.isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpIsEmptyOrLenght0()
    {
        String ip = "";

        assertFalse(Utils.isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpLengthIsLessThan6()
    {
        String ip = "1.1.1.";

        assertFalse(Utils.isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpLengthIsLessMoreThan15()
    {
        String ip = "255.255.255.2553";

        assertFalse(Utils.isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpHasNot3Dots()
    {
        String ip = "255.255.255233";

        assertFalse(Utils.isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpHasNotNumbersFrom0to255()
    {
        String ip = "255.255.25.400";

        assertFalse(Utils.isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpStartsWithDot()
    {
        String ip = ".255.255.25.1";

        assertFalse(Utils.isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpIsAllDots()
    {
        String ip = "...";

        assertFalse(Utils.isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpEndsWithDot()
    {
        String ip = "255.255.1.1.";

        assertFalse(Utils.isIpFormatted(ip));
    }

    @Test
    public void isIpFormatted_whenIpContaisOtherCharsFurtherThanDotAndNumber()
    {
        String ip = "255.&ˆ&.##).(&";

        assertFalse(Utils.isIpFormatted(ip));
    }



    @Test
    public void isIpFormatted_whenIpIsOk()
    {
        String ip = "192.168.12.123";

        assertTrue(Utils.isIpFormatted(ip));

        ip = "0.0.0.0";

        assertTrue(Utils.isIpFormatted(ip));

        ip = "255.255.255.255";

        assertTrue(Utils.isIpFormatted(ip));

        ip = "192.168.2.312";

        assertTrue(Utils.isIpFormatted(ip));
    }
}
