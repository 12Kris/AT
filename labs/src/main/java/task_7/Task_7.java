package task_7;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Task_7 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Create
            transaction = session.beginTransaction();

            Person person = new Person();
            person.setName("John Doe");
            person.setWorking(true);
            person.setTimestamp(System.currentTimeMillis());

            Address address = new Address();
            address.setStreet("123 Main St");
            address.setCity("New York");
            person.setAddress(address);

            Friends friend1 = new Friends();
            friend1.setFriendName("Jane Smith");
            friend1.setPerson(person);
            person.addFriend(friend1);

            Friends friend2 = new Friends();
            friend2.setFriendName("Bob Johnson");
            friend2.setPerson(person);
            person.addFriend(friend2);

            Hobby hobby1 = new Hobby();
            hobby1.setName("Reading");
            session.save(hobby1);

            Hobby hobby2 = new Hobby();
            hobby2.setName("Swimming");
            session.save(hobby2);

            person.addHobby(hobby1);
            person.addHobby(hobby2);

            session.save(person);
            transaction.commit();

            Long personId = person.getId();
            System.out.println("Created Person: " + person);

            // Read
            transaction = session.beginTransaction();
            person = session.get(Person.class, personId);
            System.out.println("Read Person: " + person);
            System.out.println("Address: " + person.getAddress());
            System.out.println("Friends: " + person.getFriends());
            System.out.println("Hobbies: " + person.getHobbies());
            transaction.commit();

            // Update
            transaction = session.beginTransaction();
            person.setName("John Smith");
            person.getAddress().setCity("Los Angeles");
            person.getFriends().get(0).setFriendName("Jane Doe");
            Hobby newHobby = new Hobby();
            newHobby.setName("Cooking");
            session.save(newHobby);
            person.addHobby(newHobby);
            session.update(person);
            transaction.commit();

            transaction = session.beginTransaction();
            person = session.get(Person.class, personId);
            System.out.println("Updated Person: " + person);
            System.out.println("Updated Address: " + person.getAddress());
            System.out.println("Updated Friends: " + person.getFriends());
            System.out.println("Updated Hobbies: " + person.getHobbies());
            transaction.commit();

            // Delete
            transaction = session.beginTransaction();
            person = session.get(Person.class, personId);
            if (person != null) {
                session.delete(person);
            }
            transaction.commit();

            transaction = session.beginTransaction();
            person = session.get(Person.class, personId);
            System.out.println("After Person Deletion: " + person);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}