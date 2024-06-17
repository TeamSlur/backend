package slur.teamslur.backend.Domain.Message.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import slur.teamslur.backend.Domain.Message.DTO.ChatMessage;
import slur.teamslur.backend.Domain.Message.Service.ChatMessageService;

@RequiredArgsConstructor
@Controller
public class ChatMessageController {

    private final SimpMessageSendingOperations simpMessageSendingOperations;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat/{projId}/message")
    public void sendMessage(@DestinationVariable Long projId, @Payload ChatMessage chatMessage) {
        System.out.println(chatMessage.getContent());
        chatMessageService.saveMessage(chatMessage);
        simpMessageSendingOperations.convertAndSend("/sub/chat/" + projId, chatMessage.getContent());
    }

    @GetMapping("/chat/{projId}")
    public ResponseEntity<Page<ChatMessage>> getAllChatsByProjId(@PathVariable Long projId, Pageable pageable) {
        if (projId == null) {
            return ResponseEntity.badRequest().build();
        }

        Page<ChatMessage> chatPage = chatMessageService.getChats(projId.intValue(), pageable);
        return ResponseEntity.status(HttpStatus.OK).body(chatPage);
    }
}
