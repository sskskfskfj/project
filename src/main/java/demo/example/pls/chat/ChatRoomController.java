package demo.example.pls.chat;

import demo.example.pls.authorization.User;
import demo.example.pls.authorization.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    @GetMapping("/chat")
    public String showChatPage(Model model) {
        List<ChatRoom> rooms = chatRoomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "chat";
    }

    @GetMapping("/room/{roomId}")
    public String joinRoom(@PathVariable("roomId") Long roomId,
                           Model model,
                           HttpSession session) {
        Optional<ChatRoom> optionalRoom = chatRoomRepository.findById(roomId);
        User user = (User) session.getAttribute("user");

        if(optionalRoom.isPresent()) {
            ChatRoom room = optionalRoom.get();
            model.addAttribute("room", room);
            model.addAttribute("username",user.getUsername());
            return "chat-room";
        } else {
            return "redirect:/chat";
        }
    }

    @PostMapping("/chat/create")
    public String createRoom(@RequestParam("roomName") String roomName,
                             Model model,
                             HttpSession session) {
        ChatRoom room = new ChatRoom();
        room.setRoomName(roomName);
        chatRoomRepository.save(room);
        Long roomId = room.getId();
        User user = (User) session.getAttribute("user");
        model.addAttribute("username",user.getUsername());
        return "redirect:/room/" + roomId;
    }

}
