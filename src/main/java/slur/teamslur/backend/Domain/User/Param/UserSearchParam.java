package slur.teamslur.backend.Domain.User.Param;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSearchParam {
    private String email;
    private String name;
}
