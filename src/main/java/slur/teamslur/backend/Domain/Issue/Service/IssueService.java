package slur.teamslur.backend.Domain.Issue.Service;

import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.Issue.DTO.GetIssuesDTO;
import slur.teamslur.backend.Domain.Issue.Repository.IssueRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService {
    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository){
        this.issueRepository=issueRepository;
    }



    public List<GetIssuesDTO> getIssuebyProjId(Integer projId) {
/*
        List<IssueEntity> issueEntityList = issueRepository.findAllByProjId(projId);

        List<GetIssuesDTO> getIssuesDTOList = issueEntityList.stream()
                .map(issueEntity -> GetIssuesDTO.builder()
                        .id(issueEntity.getId())
                        .title(issueEntity.getTitle())
                        .description(issueEntity.getDescription())
                        // 필요한 필드들을 추가하세요
                        .build())
                .collect(Collectors.toList());
*/
        return new ArrayList<>();
    }
}
