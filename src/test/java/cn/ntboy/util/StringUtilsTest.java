package cn.ntboy.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void isInteger() {
        assertFalse(StringUtils.isInteger(null));
        assertTrue(StringUtils.isInteger("123"));
        assertTrue(StringUtils.isInteger("+1"));
        assertFalse(StringUtils.isInteger("-"));
        assertTrue(StringUtils.isInteger("-1"));
        assertFalse(StringUtils.isInteger("1.1"));
    }
}