package task_3;
/*
Array Rotation: Write a Java program that takes an array of integers and rotates it by a given number of positions.
Your program should prompt the user to enter the array size and the elements of the array, and then the number of
positions to rotate the array. Finally, your program should output the rotated array.
Make LinkedList from the result array and perform the following operations:
 a) Add an element to the beginning of the list;
 b) Add an element to the end of the list;
 c) Remove the first element from the list;
 d) Remove the last element from the list;
 e) Print the elements of the list in reverse order;
Make up the situation for NumberFormatException.
Catch it and display the explanation for your custom case.
*/

import java .util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4,5,6,7,8));
        System.out.println("List: "+ list);

        list.add(0, 1);
        System.out.println("Added an element to the beginning "+ list);

        list.add(10);
        System.out.println("Added an element to the end "+list);

        list.remove(0);
        System.out.println("Removed the first element "+list);

        list.remove(list.size() - 1);
        System.out.println("Removed the last element "+list);

        Collections.reverse(list);
        System.out.println("Reverse order "+list);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter an integer: ");
        String userInput = scanner.nextLine();

        try {
            int number = Integer.parseInt(userInput);
            System.out.println("You entered the valid integer: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. '" + userInput + "' is not a valid integer.");
            System.out.println("Explanation: The input must be a whole number without decimal points or alphabetic characters.");
        }

        scanner.close();
    }
}
