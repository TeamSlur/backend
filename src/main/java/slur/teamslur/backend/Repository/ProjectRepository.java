package slur.teamslur.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slur.teamslur.backend.Entity.ProjectEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer> {
}
