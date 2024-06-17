package slur.teamslur.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateProjectDTO {
    private String userId;
    private String projName;
    private String nickName;
}
