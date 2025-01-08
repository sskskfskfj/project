package demo.example.pls.chat;

<<<<<<< HEAD
import demo.example.pls.authorization.User;
import demo.example.pls.authorization.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
=======
import demo.example.pls.authorization.UserRepository;
import jakarta.transaction.Transactional;
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
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
<<<<<<< HEAD
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;
=======
public class ChatRoomController {
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private UserRepository userRepository;
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7

    @GetMapping("/chat")
    public String showChatPage(Model model) {
        List<ChatRoom> rooms = chatRoomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "chat";
    }

    @GetMapping("/room/{roomId}")
<<<<<<< HEAD
    public String joinRoom(@PathVariable("roomId") Long roomId,
                           Model model,
                           HttpSession session) {
        Optional<ChatRoom> optionalRoom = chatRoomRepository.findById(roomId);
        User user = (User) session.getAttribute("user");

        if(optionalRoom.isPresent()) {
            ChatRoom room = optionalRoom.get();
            model.addAttribute("room", room);
            model.addAttribute("username",user.getUsername());
=======
    public String joinRoom(@PathVariable("roomId") Long roomId, Model model) {
        Optional<ChatRoom> optionalRoom = chatRoomRepository.findById(roomId);
        if(optionalRoom.isPresent()) {
            ChatRoom room = optionalRoom.get();
            model.addAttribute("room", room);
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
            return "chat-room";
        } else {
            return "redirect:/chat";
        }
    }

    @PostMapping("/chat/create")
<<<<<<< HEAD
    public String createRoom(@RequestParam("roomName") String roomName,
                             Model model,
                             HttpSession session) {
=======
    public String createRoom(@RequestParam("roomName") String roomName, Model model) {
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
        ChatRoom room = new ChatRoom();
        room.setRoomName(roomName);
        chatRoomRepository.save(room);
        Long roomId = room.getId();
<<<<<<< HEAD
        User user = (User) session.getAttribute("user");
        model.addAttribute("username",user.getUsername());
=======
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
        return "redirect:/room/" + roomId;
    }

}
