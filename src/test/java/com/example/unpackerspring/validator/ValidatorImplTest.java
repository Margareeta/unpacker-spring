package com.example.unpackerspring.validator;

import com.example.unpackerspring.exceptions.DigitAndBracketsException;
import com.example.unpackerspring.exceptions.LatinLetterException;
import com.example.unpackerspring.exceptions.PairOfBracketsException;
import com.example.unpackerspring.exceptions.SpaceException;
import com.example.unpackerspring.service.UnpackerStringService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidatorImplTest {
    private final UnpackerStringService service;

    @Autowired
    public ValidatorImplTest(UnpackerStringService service) {
        this.service = service;
    }

    @Test
    public void pairOfBracketsTestWithException() throws PairOfBracketsException {
        Validator validator = new ValidatorImpl("][abc]]");

        Assertions.assertThrows(PairOfBracketsException.class, () -> validator.pairOfBracketsValidation());
    }

    @Test
    public void pairOfBracketsTest() throws PairOfBracketsException {
        Validator validator = new ValidatorImpl("[sdf]");
        validator.pairOfBracketsValidation();
    }

    @Test
    public void spaceTestWithException() throws SpaceException {
        Validator validator = new ValidatorImpl("[ab ]");

        Assertions.assertThrows(SpaceException.class, () -> validator.spaceValidation());
    }

    @Test
    public void spaceTest() throws SpaceException {
        Validator validator = new ValidatorImpl("[abc]");
        validator.spaceValidation();
    }

    @Test
    public void digitAndBracketsTestWithException(){
        Validator validator = new ValidatorImpl("2a");

        Assertions.assertThrows(DigitAndBracketsException.class, () -> validator.digitAndBracketsValidation());
    }

    @Test
    public void digitAndBrackets() throws DigitAndBracketsException {
        Validator validator = new ValidatorImpl("2[ab]");
        validator.digitAndBracketsValidation();
    }

    @Test
    public void latinLettersTestWithException(){
        Validator validator = new ValidatorImpl("2[abь]а");

        Assertions.assertThrows(LatinLetterException.class, () -> validator.latinLettersValidation());
    }

    @Test
    public void latinLettersTest() throws LatinLetterException {
        Validator validator = new ValidatorImpl("2[ab]");
        validator.latinLettersValidation();
    }

}