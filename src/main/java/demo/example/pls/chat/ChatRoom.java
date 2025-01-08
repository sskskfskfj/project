package demo.example.pls.chat;

<<<<<<< HEAD
import demo.example.pls.authorization.User;
=======
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String roomName;
<<<<<<< HEAD

=======
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
}
