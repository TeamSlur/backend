package slur.teamslur.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slur.teamslur.backend.DTO.RequestCreateProjectDTO;
import slur.teamslur.backend.DTO.ResponseCreateProjectDTO;
import slur.teamslur.backend.Entity.ProjectEntity;
import slur.teamslur.backend.Service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // 프로젝트 생성
    @PostMapping
    public ResponseEntity<ResponseCreateProjectDTO> createProjectWithMembers(@RequestBody RequestCreateProjectDTO createProjectDTO){
        ResponseCreateProjectDTO response = projectService.saveProjectWithMembers(createProjectDTO);
        return ResponseEntity.ok(response);
    }

    // 참여 중인 프로젝트 조회
    @GetMapping()
    public ResponseEntity<List<ProjectEntity>> searchProjectsByUserId(@RequestBody String userId){
        return projectService.searchProjectsByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectEntity> getProject(@PathVariable int id) {
        ProjectEntity project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        List<ProjectEntity> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }
}
