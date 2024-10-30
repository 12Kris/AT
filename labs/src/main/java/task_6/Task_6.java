package task_6;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Task_6 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create
        Person person = new Person();
        person.setName("Alice");
        person.setWorking(true);
        person.setTimestamp(System.currentTimeMillis());

        Transaction transaction = session.beginTransaction();
        Long personId = (Long) session.save(person);
        transaction.commit();
        System.out.println("Created Person: " + person);

        // Update
        person.setName("Alice Johnson");
        transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        System.out.println("Updated Person: " + person);

        // Read
        person = session.get(Person.class, personId);
        System.out.println("Read Person: " + person);

        // Create and add a friend
        Friends friend = new Friends();
        friend.setFriendName("Bob");
        friend.setPerson(person);

        transaction = session.beginTransaction();
        Long friendId = (Long) session.save(friend);
        transaction.commit();
        System.out.println("Added Friend: " + friend);

        // Read person with friend
        person = session.get(Person.class, personId);
        System.out.println("Person with Friend: " + person);
        System.out.println("Friends: " + person.getFriends());

        // Delete friend
        transaction = session.beginTransaction();
        session.delete(friend);
        transaction.commit();
        System.out.println("Deleted Friend");

        // Delete person
        transaction = session.beginTransaction();
        session.delete(person);
        transaction.commit();
        System.out.println("Deleted Person");

        // Verify
        person = session.get(Person.class, personId);
        System.out.println("After Person Deletion: " + person);

        friend = session.get(Friends.class, friendId);
        System.out.println("After Friend Deletion: " + friend);

        session.close();
        HibernateUtil.shutdown();
    }
}