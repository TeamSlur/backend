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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
