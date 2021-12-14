package com.example.unpackerspring.service.domain;

import com.example.unpackerspring.service.UnpackerStringService;
import com.example.unpackerspring.exceptions.MyValidationException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

class UnpackerStringTest {
    static UnpackerStringService unpackerStringService;

    @BeforeClass
    public static void init() {
        unpackerStringService = new UnpackerStringService();
    }

    @Test
    public void testMutiplyer() {

        String actual = unpackerStringService.stringMultiplyer("3[xyz]");
        String expected = "xyzxyzxyz";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack() throws MyValidationException {

        String actual = unpackerStringService.unpack("2[4[ab]c]3[2[z]xy]");
        String expected = "ababababcababababczzxyzzxyzzxy";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack1() throws MyValidationException {

        String actual = unpackerStringService.unpack("3[ab]4[cde]");
        String expected = "abababcdecdecdecde";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack2() throws MyValidationException {

        String actual = unpackerStringService.unpack("3[2[ab]]");
        String expected = "abababababab";

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testUnpack3() throws MyValidationException {

        String actual = unpackerStringService.unpack("2[2[2[a]c]]");
        String expected = "aacaacaacaac";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack4() throws MyValidationException {

        String actual = unpackerStringService.unpack("abc");
        String expected = "abc";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack5() throws MyValidationException {

        String actual = unpackerStringService.unpack("7[a]");
        String expected = "aaaaaaa";

        Assert.assertEquals(expected, actual);
    }
}