package task_1;
/*V 10: Character Operations
Objective: To understand and use primitive char type in Java.
Instructions:
Declare a char variable.
Use Character methods (e.g., isDigit, isLetter, toUpperCase, toLowerCase) to manipulate the char.
Print the result of each operation to the console.
*/

public class Task1 {
    public static void main(String[] args) {
        char character = 'a';

        System.out.println("Character: " + character);

        boolean isLetter = Character.isLetter(character);
        System.out.println("Is letter: " + isLetter);

        char upperCaseChar = Character.toUpperCase(character);
        System.out.println("Upper case: " + upperCaseChar);

        char lowerCaseChar = Character.toLowerCase(character);
        System.out.println("Lower case: " + lowerCaseChar);

        boolean isUpperCase = Character.isUpperCase(character);
        System.out.println("Is uppercase: " + isUpperCase);

        boolean isLowerCase = Character.isLowerCase(character);
        System.out.println("Is lowercase: " + isLowerCase);

    }
}
