package task_6;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "friends")
public class Friends implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "friend_name")
    private String friendName;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", friendName='" + friendName + '\'' +
                ", person=" + (person != null ? person.getName() : "null") +
                '}';
    }
}