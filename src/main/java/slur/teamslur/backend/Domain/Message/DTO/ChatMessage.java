package slur.teamslur.backend.Domain.Message.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import slur.teamslur.backend.Domain.Message.Entity.ChatMessageEntity;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ChatMessage {
    private int projId;
    private String userId;
    private String content;
    private LocalDateTime time;

    public ChatMessageEntity toEntity(){
        return ChatMessageEntity.builder()
                .projId(projId)
                .userId(userId)
                .content(content)
                .time(time)
                .build();
    }

    public ChatMessage(ChatMessageEntity chatMessage){
        this.projId = chatMessage.getProjId();
        this.userId = chatMessage.getUserId();
        this.content = chatMessage.getContent();
        this.time = chatMessage.getTime();
    }
}