package task_4;
/*
Create your own custom class, and make an object for it.
Use getDeclaredMethods() to print out all the methods of the class and their return types.
Choose a specific method by name and call it using invoke(). Print out your results of invoking.
 */

import java.lang.reflect.Method;

public class Task4B {
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String greet() {
            return "Hello, my name is " + name + " and I am " + age + " years old.";
        }
    }
    public static void main(String[] args) {
        try {
            Person person = new Person("Kris", 19);

            Class<?> personClass = person.getClass();

            Method[] methods = personClass.getDeclaredMethods();

            System.out.println("Declared methods and their return types:");
            for (Method method : methods) {
                System.out.println(method.getName() + " - Return type: " + method.getReturnType());
            }

            Method greetMethod = personClass.getDeclaredMethod("greet");

            String result = (String) greetMethod.invoke(person);

            System.out.println("\nResult of invoking 'greet' method: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
