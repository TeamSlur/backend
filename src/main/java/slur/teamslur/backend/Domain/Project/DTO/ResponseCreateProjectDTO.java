package slur.teamslur.backend.Domain.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCreateProjectDTO {
    private String userId;
    private int projId;
    private String projName;
    private String nickName;
}
