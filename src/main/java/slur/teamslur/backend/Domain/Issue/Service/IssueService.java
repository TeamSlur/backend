package slur.teamslur.backend.Domain.Issue.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.Issue.DTO.GetIssuesDTO;
import slur.teamslur.backend.Domain.Issue.Entity.IssueEntity;
import slur.teamslur.backend.Domain.Issue.Repository.IssueRepository;
import slur.teamslur.backend.Domain.Message.DTO.ChatMessage;
import slur.teamslur.backend.Domain.Message.Entity.ChatMessageEntity;
import slur.teamslur.backend.Domain.User.DTO.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {
    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository){
        this.issueRepository=issueRepository;
    }



    //TODO : 이슈 조회 관련해서 Entuty <-> DTO 전환 처리 필요
    /*public List<GetIssuesDTO> getIssuebyProjId(Integer projId) {
        List<IssueEntity> entityList = issueRepository.findIssueByProjID(projId).stream().map(GetIssuesDTO::);
        return entityList.stream().map(GetIssuesDTO::new).collect(Collectors.toList());
    }*/
}
