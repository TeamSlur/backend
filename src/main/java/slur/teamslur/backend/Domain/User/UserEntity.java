package slur.teamslur.backend.Domain.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import slur.teamslur.backend.Domain.User.Param.UserSignUpParam;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_user")
public class UserEntity {
    @Id
    private String user_id;
    private String user_name;
    private String user_pwd;
    private String user_email;

    public UserEntity(UserSignUpParam signUpParam){
        this.user_id = signUpParam.getId();
        this.user_name = signUpParam.getName();
        this.user_email = signUpParam.getEmail();
        this.user_pwd = signUpParam.getPwd();
    }
}
