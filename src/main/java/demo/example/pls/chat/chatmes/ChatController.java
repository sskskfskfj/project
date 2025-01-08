package demo.example.pls.chat.chatmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

<<<<<<< HEAD
=======
    @GetMapping("/chatcontent")
    public String showChatPage(Model model) {
        model.addAttribute("messages", chatMessageRepository.findAll());
        return "chat";
    }

>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
    @PostMapping("/send-message")
    public String sendMessage(@RequestParam("message") String message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setContent(message);
        chatMessageRepository.save(chatMessage);

        return "redirect:/chat";
    }
<<<<<<< HEAD

=======
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
