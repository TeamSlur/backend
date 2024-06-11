package slur.teamslur.backend.Domain.User.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.User.DTO.UserDTO;
import slur.teamslur.backend.Domain.User.DTO.UserSignUpParam;
import slur.teamslur.backend.Domain.User.Entity.UserEntity;
import slur.teamslur.backend.Domain.User.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService{
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
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

    public UserEntity createUser(UserSignUpParam signUpParam){
        signUpParam.pwdEncode();
        UserEntity userEntity = signUpParam.toEntity();
        return repository.save(userEntity);
    }

    public UserEntity findById(String id) {
        return repository.findById(id);
    }
}
