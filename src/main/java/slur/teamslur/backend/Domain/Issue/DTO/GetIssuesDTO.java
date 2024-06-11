package slur.teamslur.backend.Domain.Issue.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import slur.teamslur.backend.Domain.Issue.Entity.IssueEntity;
import slur.teamslur.backend.Domain.Message.Entity.ChatMessageEntity;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetIssuesDTO {
    private int projId;
    private String userId;
    private String type;
    private String progress;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;

    public IssueEntity toEntity() {
        return IssueEntity.builder()
                .projId(projId)
                .userId(userId)
                .type(type)
                .progress(progress)
                .title(title)
                .content(content)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
