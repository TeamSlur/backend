package slur.teamslur.backend.Domain.Issue.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import slur.teamslur.backend.Domain.Issue.DTO.GetIssuesDTO;
import slur.teamslur.backend.Domain.Issue.Service.IssueService;

import java.util.List;

@RestController
public class IssueController {
    private IssueService issueService;

/*    @GetMapping("/{projId}/issues")
    public List<GetIssuesDTO> getAllIssuesbyProjId(@PathVariable Integer projId) {
        List<GetIssuesDTO> issueList = issueService.getIssuebyProjId(projId);
        return issueList;
    }*/
}
