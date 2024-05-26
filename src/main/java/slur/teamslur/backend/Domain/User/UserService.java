package slur.teamslur.backend.Domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.User.Param.UserSignUpParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService{
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> getAllUsers() {
        return repository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public UserSignUpParam signUpUsers(UserSignUpParam signUpParam) {
        repository.save(new UserEntity(signUpParam));
        return signUpParam;
    }

//    public UserDTO findIdByEmail(String email){
//        UserEntity userEntity = repository.findByUser_email(email);
//        if (userEntity != null) {
//            return new UserDTO(userEntity);
//        }
//        return null;
//    }
}
