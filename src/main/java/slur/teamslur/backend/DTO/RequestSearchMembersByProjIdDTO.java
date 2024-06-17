package slur.teamslur.backend.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestSearchMembersByProjIdDTO {
    private String userId;
    private int projId;
    private String projectName;
    private String nickName;

    public RequestSearchMembersByProjIdDTO(String userId, int projId, String projectName, String nickName) {
        this.userId = userId;
        this.projId = projId;
        this.projectName = projectName;
        this.nickName = nickName;
    }
}
