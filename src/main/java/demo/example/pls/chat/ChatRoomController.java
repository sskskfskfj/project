package demo.example.pls.chat;

import demo.example.pls.authorization.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ChatRoomController {
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/chat")
    public String showChatPage(Model model) {
        List<ChatRoom> rooms = chatRoomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "chat";
    }

    @GetMapping("/room/{roomId}")
    public String joinRoom(@PathVariable("roomId") Long roomId, Model model) {
        Optional<ChatRoom> optionalRoom = chatRoomRepository.findById(roomId);
        if(optionalRoom.isPresent()) {
            ChatRoom room = optionalRoom.get();
            model.addAttribute("room", room);
            return "chat-room";
        } else {
            return "redirect:/chat";
        }
    }

    @PostMapping("/chat/create")
    public String createRoom(@RequestParam("roomName") String roomName, Model model) {
        ChatRoom room = new ChatRoom();
        room.setRoomName(roomName);
        chatRoomRepository.save(room);
        Long roomId = room.getId();
        return "redirect:/room/" + roomId;
    }

}
