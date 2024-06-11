package slur.teamslur.backend.Domain.Issue.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class IssueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int projId;
    private String userId;
    private String type;
    private String progress;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;

    @Builder
    public IssueEntity(int projId, String userId, String type,String progress, String title, String content, Date startDate,Date endDate) {
        this.projId = projId;
        this.userId = userId;
        this.type =type;
        this.progress = progress;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
