package slur.teamslur.backend.Domain.Document.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slur.teamslur.backend.Domain.Document.Entity.DocEntity;

@Repository
public interface DocRepository extends JpaRepository<DocEntity,Integer> {
}
