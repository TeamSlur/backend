package slur.teamslur.backend.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import slur.teamslur.backend.DTO.*;
import slur.teamslur.backend.Entity.UserEntity;
import slur.teamslur.backend.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.userRepository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public RequestSignUpUserDTO signUpUsers(RequestSignUpUserDTO signUpParam) {
        userRepository.save(new UserEntity(signUpParam));
        return signUpParam;
    }

    public UserEntity createUser(RequestSignUpUserDTO signUpParam){
        signUpParam.pwdEncode();
        UserEntity userEntity = signUpParam.toEntity();
        return userRepository.save(userEntity);
    }

    public ResponseEntity<ResponseSignInUserDTO> signInUser(RequestSignInUserDTO signInUserDTO) {
        Optional<UserEntity> userEntity = userRepository.findById(signInUserDTO.getId());

        if (userEntity.isPresent() && passwordEncoder.matches(signInUserDTO.getPwd(), userEntity.get().getPwd())) {
            ResponseSignInUserDTO response = new ResponseSignInUserDTO(
                    userEntity.get().getId(),
                    userEntity.get().getName(),
                    userEntity.get().getEmail()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public UserDTO findByIdTwo(String id) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOrigin = this.userRepository.findById(id);
        if (userEntityOrigin.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        UserEntity userEntity = userEntityOrigin.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(id)){
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        }
        else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new UserDTO(userEntity.getId(),userEntity.getName(),userEntity.getEmail());
    }
}


