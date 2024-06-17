package slur.teamslur.backend.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import slur.teamslur.backend.Entity.ChatMessageEntity;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Integer> {
    Page<ChatMessageEntity> findChatMessageEntitiesByProjId(int projId, Pageable pageable);
}