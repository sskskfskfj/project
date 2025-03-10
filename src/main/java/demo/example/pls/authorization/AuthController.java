package demo.example.pls.authorization;

<<<<<<< HEAD
import demo.example.pls.chat.ChatRoomRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
=======
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
<<<<<<< HEAD
@RequiredArgsConstructor
public class AuthController {
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    @GetMapping({"/signup","/"})
=======
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        User existingUserByUsername = userRepository.findByUsername(user.getUsername());
        if (existingUserByUsername != null) {
            redirectAttributes.addFlashAttribute("error", "Username already exists!");
            return "redirect:/signup";
        }

        User existingUserByEmail = userRepository.findByEmail(user.getEmail());
        if (existingUserByEmail != null) {
            redirectAttributes.addFlashAttribute("error", "Email already exists!");
            return "redirect:/signup";
        }

        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
<<<<<<< HEAD
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            session.setAttribute("user",user);
=======
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
>>>>>>> 25f939f14434565878bf3ab7ccabb1309cb09bb7
            return "redirect:/chat";
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
    }
}
