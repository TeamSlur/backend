package slur.teamslur.backend.Domain.User.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignUpParam {
    private String id;
    private String name;
    private String email;
    private String pwd;
}
