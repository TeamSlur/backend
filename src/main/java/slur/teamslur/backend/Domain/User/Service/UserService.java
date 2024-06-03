package slur.teamslur.backend.Domain.User.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.User.DTO.UserDTO;
import slur.teamslur.backend.Domain.User.DTO.UserSignUpParam;
import slur.teamslur.backend.Domain.User.Entity.UserEntity;
import slur.teamslur.backend.Domain.User.Repository.UserRepository;

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
}
