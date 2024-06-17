package slur.teamslur.backend.Domain.Message.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.Message.DTO.ChatMessage;
import slur.teamslur.backend.Domain.Message.Entity.ChatMessageEntity;
import slur.teamslur.backend.Domain.Message.Repository.ChatMessageRepository;

@Service
public class ChatMessageService {
    private final ChatMessageRepository repository;

    public ChatMessageService(ChatMessageRepository repository){
        this.repository = repository;
    }

    public void saveMessage(ChatMessage chatMessage) {
        repository.save(chatMessage.toEntity());
    }

    public Page<ChatMessage> getChats(int projId, Pageable pageable) {
        Page<ChatMessageEntity> entityPage = repository.findChatMessageEntitiesByProjId(projId, pageable);
        return entityPage.map(ChatMessage::new);
    }
}
