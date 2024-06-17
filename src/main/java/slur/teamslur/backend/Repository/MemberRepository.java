package slur.teamslur.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import slur.teamslur.backend.Entity.MemberEntity;
import slur.teamslur.backend.Entity.ProjectEntity;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {
    List<MemberEntity> findByProjId(@Param("projId") int projId);

    MemberEntity findByProjIdAndUserId(int projId, String userId);

    List<ProjectEntity> findProjectsByUserId(String userId);
}
