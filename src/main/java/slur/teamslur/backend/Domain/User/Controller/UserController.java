package slur.teamslur.backend.Domain.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import slur.teamslur.backend.Domain.User.DTO.RequestSignInUserDTO;
import slur.teamslur.backend.Domain.User.DTO.ResponseSignInUserDTO;
import slur.teamslur.backend.Domain.User.Service.UserService;
import slur.teamslur.backend.Domain.User.DTO.RequestSignUpUserDTO;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) { this.userService = userService;}
    @GetMapping
    public String welcome() {
        return "welcome";
    }

    // 회원가입
    @PostMapping("/users")
    public RequestSignUpUserDTO signUpUser(@RequestBody RequestSignUpUserDTO signUpParam) {
        userService.createUser(signUpParam);
        return signUpParam;
    }

    // 로그인 (약식)
    @PostMapping("/users/login")
    public ResponseEntity<ResponseSignInUserDTO> signInUser(@RequestBody RequestSignInUserDTO signInUserDTO) {
        return userService.signInUser(signInUserDTO);
    }

    // 로그아웃 (뭐해야하노)
    @PostMapping("/users/logout")
    public String signOutUser(){
        return "sign out";
    }

    /*
    // 로그인 (by. web security)
    @GetMapping("/users/login")
    public String login() {
        return "login_form";

    @GetMapping("/users")
    public List<UserEntity> userList() {
        return service.getAllUsers();
    }

    @GetMapping("/users/info")
    public UserEntity getParameter(RequestSearchUserDTO searchParam) {
        return service.findById(searchParam.getId());
    }
     */

}
