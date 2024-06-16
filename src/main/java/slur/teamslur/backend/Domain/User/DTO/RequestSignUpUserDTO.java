package slur.teamslur.backend.Domain.User.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import slur.teamslur.backend.Domain.User.Entity.UserEntity;

@Data
@AllArgsConstructor
public class RequestSignUpUserDTO {
    private String id;
    private String name;
    private String email;
    private String pwd;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(id)
                .name(name)
                .email(email)
                .pwd(pwd)
                .build();
    }

    public void pwdEncode() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.pwd = passwordEncoder.encode(this.pwd);
    }
}
