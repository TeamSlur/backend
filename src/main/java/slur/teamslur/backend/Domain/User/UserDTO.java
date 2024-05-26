package slur.teamslur.backend.Domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;

    public UserDTO(UserEntity entity){
        this.id=entity.getUser_id();
        this.name=entity.getUser_name();
        this.email=entity.getUser_email();
    }
}
