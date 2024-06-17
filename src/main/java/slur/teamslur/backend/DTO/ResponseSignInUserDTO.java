package slur.teamslur.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSignInUserDTO {
    private String id;
    private String name;
    private String email;
}
