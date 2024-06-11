package slur.teamslur.backend.Domain.Issue.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetTimelineDTO {
    private int id;
    private int projId;
    private String type;
    private String progress;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;


}
