package task_8;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;  // TestNG
import task_2.Task2;

/*1: Create 3 simple unit tests for Task_2 (modify your code to have 3 different methods in Task_2 solving if needed).
2. Create testng.xml which should execute your test class. Execute this file
3. Add a Data provider for each test.
4. Create a test with parameters loaded from testng.xml. */

public class Task_8 {
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

    @Parameters ({ "input", "result" })
    @Test
    public void isLetterWithParameterTest(char input, boolean result) {
        Assert.assertEquals(new Task2().isLetter(input), result, "isLetter method failed");
    }

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