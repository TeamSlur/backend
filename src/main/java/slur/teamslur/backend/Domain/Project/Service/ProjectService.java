package slur.teamslur.backend.Domain.Project.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.Project.DTO.RequestCreateProjectDTO;
import slur.teamslur.backend.Domain.Project.DTO.ResponseCreateProjectDTO;
import slur.teamslur.backend.Domain.Project.Entity.MemberEntity;
import slur.teamslur.backend.Domain.Project.Entity.ProjectEntity;
import slur.teamslur.backend.Domain.Project.Repository.MemberRepository;
import slur.teamslur.backend.Domain.Project.Repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MemberRepository memberRepository;

    // 프로젝트 생성 -> project, member 테이블 접근
    // project repository랑 member repository 접근
    @Transactional
    public ResponseCreateProjectDTO saveProjectWithMembers(RequestCreateProjectDTO createProjectDTO) {
        ProjectEntity projectEntity = projectRepository.save(
                ProjectEntity.builder()
                        .name(createProjectDTO.getProjName())
                        .build());
        MemberEntity memberEntity = memberRepository.save(
                MemberEntity.builder()
                        .userId(createProjectDTO.getUserId())
                        .projId(projectEntity.getProjId())
                        .nickName(createProjectDTO.getNickName())
                        .build());
        return new ResponseCreateProjectDTO(
                memberEntity.getUserId(),
                memberEntity.getProjId(),
                projectEntity.getName(),
                memberEntity.getNickName()
        );
    }


    // User Id로 프로젝트 조회
    public ResponseEntity<List<ProjectEntity>> searchProjectsByUserId(String userId) {
        try {
            List<ProjectEntity> projects = memberRepository.findProjectsByUserId(userId);
            if (projects.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(projects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ProjectEntity getProjectById(int id) {
        Optional<ProjectEntity> project = projectRepository.findById(id);
        return project.orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }


}
