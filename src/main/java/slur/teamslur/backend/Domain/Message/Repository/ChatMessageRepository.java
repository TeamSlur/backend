package slur.teamslur.backend.Domain.Message.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import slur.teamslur.backend.Domain.Message.DTO.ChatMessage;
import slur.teamslur.backend.Domain.Message.Entity.ChatMessageEntity;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Integer> {
    Page<ChatMessageEntity> findChatMessageEntitiesByProjId(int projId, Pageable pageable);
}