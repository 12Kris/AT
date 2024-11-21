package task_13;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task_2.Task2;

/*
General task
Implement custom Listeners with methods for your variant.
Add logging for all overridden listener methods using log4j console and file appenders
Add video recorder for onFail action (you can use any lib for that)
 */

//@Listeners(Task13_Listener.class)

public class Task_13Test {
    @Test
    public void isLetterTest() {
        Assert.assertEquals(new Task2().isLetter('f'), true, "isLetter method failed");
    }

    @Test (dataProvider = "letterProvider")
    public void isLetterDataProviderTest(char inputCharacter, boolean expected) {
        Assert.assertEquals(new Task2().isLetter(inputCharacter), expected, "isLetter method failed");
    }

    @DataProvider
    public Object [][] letterProvider(){
        return new Object[][] {
                {'a', true},
                {'b', true},
                {'3', false}
        };
    }

 /*   @Parameters ({ "input", "result" })
    @Test
    public void isLetterWithParameterTest(char input, boolean result) {
        Assert.assertEquals(new Task2().isLetter(input), result, "isLetter method failed");
    }*/

    @Test
    public void isLetterUppercase() {
        Assert.assertEquals(new Task2().isUpperCase('A'), true, "isUpperCase method failed");
    }

    @Test (dataProvider = "UpperCaseProvider")
    public void isLetterUppercaseDataProviderTest(char inputCharacter, boolean expected)  {
        Assert.assertEquals(new Task2().isUpperCase(inputCharacter), expected, "isUpperCase method failed");
    }

    @DataProvider
    public Object [][] UpperCaseProvider(){
        return new Object[][] {
                {'A', true},
                {'b', false},
                {'3', false}
        };
    }

    @Test
    public void isLetterLowerCase() {
        Assert.assertEquals(new Task2().isLowerCase('c'), true, "isLowerCase method failed");
    }

    @Test (dataProvider = "LowerCaseProvider")
    public void isLetterLowerCaseDataProviderTest(char inputCharacter, boolean expected) {
        Assert.assertEquals(new Task2().isLowerCase(inputCharacter), expected, "isLowerCase method failed");
    }

    @DataProvider
    public Object [][] LowerCaseProvider(){
        return new Object[][] {
                {'9', false},
                {'P', false},
                {'s', true}
        };
    }

}