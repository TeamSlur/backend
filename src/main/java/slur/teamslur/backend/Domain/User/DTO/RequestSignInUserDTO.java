package slur.teamslur.backend.Domain.User.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSignInUserDTO {
    private String id;
    private String pwd;
}
