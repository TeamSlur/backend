package slur.teamslur.backend.Domain.User.Controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import slur.teamslur.backend.Domain.User.DTO.LoginUserDTO;
import slur.teamslur.backend.Domain.User.DTO.SearchUserDTO;
import slur.teamslur.backend.Domain.User.Entity.UserEntity;
import slur.teamslur.backend.Domain.User.Service.UserService;
import slur.teamslur.backend.Domain.User.DTO.SignUpUserDTO;

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
    public List<UserEntity> userList() {
        return service.getAllUsers();
    }

    // ?id={userid}
    @GetMapping("/user/info")
    public UserEntity getParameter(SearchUserDTO searchParam) {
        return service.findById(searchParam.getId());
    }

    @PostMapping("/user")
    public SignUpUserDTO signUpUser(@RequestBody SignUpUserDTO signUpParam) {
        service.createUser(signUpParam);
        return signUpParam;
    }

    @GetMapping("/user/login")
    public String login() {
        return "login_form";
    }

    @PostMapping("/user/login")
    public String loginUser(@RequestBody LoginUserDTO loginUserDTO) {
        UserEntity userEntity = service.findById(loginUserDTO.getId());
        if (userEntity != null && new BCryptPasswordEncoder().matches(loginUserDTO.getPwd(), userEntity.getPwd())) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

//    @GetMapping("/forget/id")
//    public UserDTO searchIDbyEmail(@RequestParam String email){
//        return service.findIdByEmail(email);
//    }
}
