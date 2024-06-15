package slur.teamslur.backend.Domain.Project.Service;

import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Transactional
    public ProjectEntity saveProjectWithMembers(ProjectEntity project, MemberEntity member) {
        // 프로젝트를 먼저 저장합니다.
        ProjectEntity savedProject = projectRepository.save(project);
        member.setId(savedProject.getId());
        memberRepository.save(member);
        return savedProject;
    }

    public ProjectEntity createProject(ProjectEntity project) {
        return projectRepository.save(project);
    }

    public ProjectEntity getProjectById(int id) {
        Optional<ProjectEntity> project = projectRepository.findById(id);
        return project.orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    public ProjectEntity updateProject(int id, ProjectEntity project) {
        ProjectEntity existingProject = getProjectById(id);
        existingProject = ProjectEntity.builder()
                .id(existingProject.getId())
                .name(project.getName())
                .build();
        return projectRepository.save(existingProject);
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}
