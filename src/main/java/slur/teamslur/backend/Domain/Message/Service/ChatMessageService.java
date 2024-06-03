package slur.teamslur.backend.Domain.Message.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.Message.DTO.ChatMessage;
import slur.teamslur.backend.Domain.Message.DTO.ResponseChat;
import slur.teamslur.backend.Domain.Message.Repository.ChatMessageRepository;

@Service
public class ChatMessageService {
    private ChatMessageRepository repository;

    public void saveMessage(ChatMessage chatMessage) {
    }

    public Page<ResponseChat> getChats(Pageable pageable) {
        return null;
    }
}
