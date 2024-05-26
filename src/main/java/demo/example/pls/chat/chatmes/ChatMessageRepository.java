package demo.example.pls.chat.chatmes;

import demo.example.pls.chat.chatmes.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

}