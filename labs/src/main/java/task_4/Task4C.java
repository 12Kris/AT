package task_4;
/*
Create a generic method that takes two parameters of any type,
and returns the larger one using T extends Comparable<T> and compareTo().
 */

public class Task4C {
    public static <T extends Comparable<T>> T getLarger(T first, T second) {
        if (first.compareTo(second) > 0) {
            return first;
        } else {
            return second;
        }
    }

    public static void main(String[] args) {
        Integer num1 = 7;
        Integer num2 = 3;
        System.out.println("Larger of " + num1 + " and " + num2 + " is: " + getLarger(num1, num2));

        String str1 = "pineapple";
        String str2 = "orange";
        System.out.println("Larger of \"" + str1 + "\" and \"" + str2 + "\" is: " + getLarger(str1, str2));

        Double d1 = 6.5;
        Double d2 = 9.1;
        System.out.println("Larger of " + d1 + " and " + d2 + " is: " + getLarger(d1, d2));
    }
}
