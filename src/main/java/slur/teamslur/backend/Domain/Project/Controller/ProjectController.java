package slur.teamslur.backend.Domain.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slur.teamslur.backend.Domain.Project.Entity.MemberEntity;
import slur.teamslur.backend.Domain.Project.Entity.ProjectEntity;
import slur.teamslur.backend.Domain.Project.Service.ProjectService;

import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectEntity> createProjectWithMembers(@RequestBody ProjectEntity project, @RequestBody MemberEntity members) {
        // 프로젝트와 멤버 데이터를 함께 저장하고 저장된 프로젝트를 반환합니다.
        ProjectEntity savedProject = projectService.saveProjectWithMembers(project, members);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectEntity> getProject(@PathVariable int id) {
        ProjectEntity project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @GetMapping()
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        List<ProjectEntity> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectEntity> updateProject(@PathVariable int id, @RequestBody ProjectEntity project) {
        ProjectEntity updatedProject = projectService.updateProject(id, project);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
