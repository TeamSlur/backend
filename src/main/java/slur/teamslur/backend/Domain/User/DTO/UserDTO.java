package slur.teamslur.backend.Domain.User.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import slur.teamslur.backend.Domain.User.Entity.UserEntity;

@Data
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;

    public UserDTO(UserEntity entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.email=entity.getEmail();
    }
}
