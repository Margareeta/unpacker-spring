package com.example.unpackerspring.service;


import com.example.unpackerspring.exceptions.MyValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class UnpackerStringTest {

    private final UnpackerStringService unpackerStringService;
    @Autowired
    public UnpackerStringTest (UnpackerStringService unpackerStringService){
        this.unpackerStringService = unpackerStringService;
    }



    @Test
    public void testMutiplyer() {

        String actual = unpackerStringService.stringMultiplyer("3[xyz]");
        String expected = "xyzxyzxyz";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack() throws MyValidationException {

        String actual = unpackerStringService.unpack("2[4[ab]c]3[2[z]xy]");
        String expected = "ababababcababababczzxyzzxyzzxy";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack1() throws MyValidationException {

        String actual = unpackerStringService.unpack("3[ab]4[cde]");
        String expected = "abababcdecdecdecde";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack2() throws MyValidationException {

        String actual = unpackerStringService.unpack("3[2[ab]]");
        String expected = "abababababab";

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testUnpack3() throws MyValidationException {

        String actual = unpackerStringService.unpack("2[2[2[a]c]]");
        String expected = "aacaacaacaac";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack4() throws MyValidationException {

        String actual = unpackerStringService.unpack("abc");
        String expected = "abc";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack5() throws MyValidationException {

        String actual = unpackerStringService.unpack("7[a]");
        String expected = "aaaaaaa";

        Assertions.assertEquals(expected, actual);
    }
}