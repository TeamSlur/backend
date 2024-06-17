package slur.teamslur.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slur.teamslur.backend.Entity.DocEntity;

import java.util.Optional;

@Repository
public interface DocRepository extends JpaRepository<DocEntity,Integer> {
    Optional<DocEntity> findById(long docId);
}
