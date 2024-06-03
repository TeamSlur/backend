package slur.teamslur.backend.Domain.User.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import slur.teamslur.backend.Domain.User.DTO.UserSignUpParam;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String pwd;
    private String email;

    public UserEntity(UserSignUpParam signUpParam){
        this.id = signUpParam.getId();
        this.name = signUpParam.getName();
        this.email = signUpParam.getEmail();
        this.pwd = signUpParam.getPwd();
    }
}
