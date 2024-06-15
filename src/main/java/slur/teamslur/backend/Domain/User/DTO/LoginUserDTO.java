package slur.teamslur.backend.Domain.User.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginUserDTO {
    private String id;
    private String pwd;
}
