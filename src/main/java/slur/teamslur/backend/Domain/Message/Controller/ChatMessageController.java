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
import slur.teamslur.backend.Domain.Message.DTO.ChatMessage;
import slur.teamslur.backend.Domain.Message.DTO.ResponseChat;
import slur.teamslur.backend.Domain.Message.Service.ChatMessageService;

@RequiredArgsConstructor
@Controller
public class ChatMessageController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat/{chatRoomId}/message")
    public void sendMessage(@DestinationVariable Long chatRoomId,@Payload ChatMessage chatMessage){
        System.out.println(chatMessage.getMessage());
        chatMessageService.saveMessage(chatMessage);
        messagingTemplate.convertAndSend("/sub/chat/"+chatRoomId,chatMessage);
    }
    @GetMapping("/chat")
    public ResponseEntity<Page<ResponseChat>> getChats(Pageable pageable) {
        Page<ResponseChat> chatPage = chatMessageService.getChats(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(chatPage);
    }
}