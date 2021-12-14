package com.example.unpackerspring.validator;

import com.example.unpackerspring.exceptions.DigitAndBracketsException;
import com.example.unpackerspring.exceptions.LatinLetterException;
import com.example.unpackerspring.exceptions.PairOfBracketsException;
import com.example.unpackerspring.exceptions.SpaceException;
import org.junit.Test;


public class ValidatorImplTest {

    @Test(expected = PairOfBracketsException.class)
    public void pairOfBracketsTestWithException() throws PairOfBracketsException {

        Validator validator = new ValidatorImpl("][abc]]");
        validator.pairOfBracketsValidation();
    }

    @Test
    public void pairOfBracketsTest() throws PairOfBracketsException {

        Validator validator = new ValidatorImpl("[sdf]");
        validator.pairOfBracketsValidation();
    }

    @Test(expected = SpaceException.class)
    public void spaceTestWithException() throws SpaceException {
        Validator validator = new ValidatorImpl("[ab ]");
        validator.spaceValidation();
    }

    @Test
    public void spaceTest() throws SpaceException {
        Validator validator = new ValidatorImpl("[abc]");
        validator.spaceValidation();
    }

    @Test(expected = DigitAndBracketsException.class)
    public void digitAndBracketsTestWithException() throws DigitAndBracketsException {
        Validator validator = new ValidatorImpl("2a");
        validator.digitAndBracketsValidation();
    }

    @Test
    public void digitAndBrackets() throws DigitAndBracketsException {
        Validator validator = new ValidatorImpl("2[ab]");
        validator.digitAndBracketsValidation();
    }

    @Test(expected = LatinLetterException.class)
    public void latinLettersTestWithException() throws LatinLetterException {
        Validator validator = new ValidatorImpl("2[abь]а");
        validator.latinLettersValidation();
    }

    @Test
    public void latinLettersTest() throws LatinLetterException {
        Validator validator = new ValidatorImpl("2[ab]");
        validator.latinLettersValidation();
    }

}