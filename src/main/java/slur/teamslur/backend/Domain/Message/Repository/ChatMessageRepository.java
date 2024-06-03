package slur.teamslur.backend.Domain.Message.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import slur.teamslur.backend.Domain.Message.Entity.ChatMessageEntity;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Integer> {
}