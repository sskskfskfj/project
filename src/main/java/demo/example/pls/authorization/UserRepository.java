package demo.example.pls.authorization;

import demo.example.pls.authorization.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUsernameAndPassword(String username, String password);
<<<<<<< HEAD
    User findByRoomId(Long roomId);
=======

>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
}
