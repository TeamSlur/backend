package slur.teamslur.backend.Domain.User.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import slur.teamslur.backend.Domain.User.DTO.UserDTO;
import slur.teamslur.backend.Domain.User.DTO.UserSearchParam;
import slur.teamslur.backend.Domain.User.Service.UserService;
import slur.teamslur.backend.Domain.User.DTO.UserSignUpParam;

import java.util.List;

@RestController
public class UserController {
    UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/")
    public String welcome(){
        return "hello";
    }

    @GetMapping("/users")
    public List<UserDTO> userList(){
        return service.getAllUsers();
    }

    @GetMapping("/info")
    public UserSearchParam getParameter(UserSearchParam searchParam) {
        return searchParam;
    }

    @PostMapping("/user")
    public UserSignUpParam signUpUser(@RequestBody UserSignUpParam signUpParam){
        service.signUpUsers(signUpParam);
        return signUpParam;
    }

//    @GetMapping("/forget/id")
//    public UserDTO searchIDbyEmail(@RequestParam String email){
//        return service.findIdByEmail(email);
//    }
}
