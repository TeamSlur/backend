package slur.teamslur.backend.Domain.User.Controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import slur.teamslur.backend.Domain.User.DTO.UserDTO;
import slur.teamslur.backend.Domain.User.DTO.SearchUserDTO;
import slur.teamslur.backend.Domain.User.Entity.UserEntity;
import slur.teamslur.backend.Domain.User.Service.UserService;
import slur.teamslur.backend.Domain.User.DTO.UserSignUpParam;

import java.util.List;

@RestController
public class UserController {
    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String welcome() {
        return "hello";
    }

    @GetMapping("/users")
    public List<UserDTO> userList() {
        return service.getAllUsers();
    }

    // ?id={userid}
    @GetMapping("/user/info")
    public SearchUserDTO getParameter(SearchUserDTO searchParam) {
        return searchParam;
    }

    @PostMapping("/user")
    public UserSignUpParam signUpUser(@RequestBody UserSignUpParam signUpParam) {
        service.createUser(signUpParam);
        return signUpParam;
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody UserSignUpParam signUpParam){
        UserEntity userEntity = service.findById(signUpParam.getId());
        if (userEntity != null && new BCryptPasswordEncoder().matches(signUpParam.getPwd(), userEntity.getPwd())) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }

//    @GetMapping("/forget/id")
//    public UserDTO searchIDbyEmail(@RequestParam String email){
//        return service.findIdByEmail(email);
//    }
}
