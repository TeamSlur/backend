package slur.teamslur.backend.Domain.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberProjectDTO {
    private String userId;
    private int projId;
    private String projectName;
    private String nickName;

    public MemberProjectDTO(String userId, int projId, String projectName, String nickName) {
        this.userId = userId;
        this.projId = projId;
        this.projectName = projectName;
        this.nickName = nickName;
    }
}
