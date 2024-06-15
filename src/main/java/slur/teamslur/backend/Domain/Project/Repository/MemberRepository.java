package slur.teamslur.backend.Domain.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import slur.teamslur.backend.Domain.Project.Entity.MemberEntity;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {
    List<MemberEntity> findByProjId(@Param("projId") int projId);

}
