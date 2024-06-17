package slur.teamslur.backend.Domain.User.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import slur.teamslur.backend.Domain.User.DTO.RequestSignUpUserDTO;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String pwd;
    private String email;

    public UserEntity(RequestSignUpUserDTO signUpParam){
        this.id = signUpParam.getId();
        this.name = signUpParam.getName();
        this.email = signUpParam.getEmail();
        this.pwd = signUpParam.getPwd();
    }
}
