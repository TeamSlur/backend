package slur.teamslur.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import slur.teamslur.backend.Entity.UserEntity;

@Getter
@NoArgsConstructor
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
