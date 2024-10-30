package task_5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task5_Stream {
    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        List<Person> inputList = IntStream.range(1, n).mapToObj(i -> {
            Person person = new Person();
            person.setWorking(random.nextBoolean());
            person.setName(UUID.randomUUID().toString().substring(0, 8));
            person.setTimestamp(System.currentTimeMillis() + random.nextInt(1000000));
            person.setFriends(IntStream.range(0, random.nextInt(5))
                    .mapToObj(j -> UUID.randomUUID().toString().substring(0, 8))
                    .collect(Collectors.toList()));
            return person;
        }).collect(Collectors.toList());

        System.out.println("Original list:");
        inputList.forEach(System.out::println);

        List<Person> sortedList = inputList.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(Person::isWorking))
                .collect(Collectors.toList());

        System.out.println("\nSorted list by name and working status:");
        sortedList.forEach(System.out::println);

        List<Person> filteredList = inputList.stream()
                .filter(Person::isWorking)
                .filter(p -> p.getFriends().size() > 2)
                .collect(Collectors.toList());

        System.out.println("\nFiltered list (working and more than 2 friends):");
        filteredList.forEach(System.out::println);

        List<String> collectedList = inputList.stream()
                .map(p -> p.getName() + " (Working: " + p.isWorking() + ")")
                .collect(Collectors.toList());

        System.out.println("\nCollected list with main fields:");
        collectedList.forEach(System.out::println);
    }
}