package slur.teamslur.backend.Domain.Message.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ResponseChat {
    private Long id;
    private Long chatRoomId; // 방 번호
    private Long senderId;
    private String message;
    private LocalDateTime sendTime;

    public ResponseChat(Long id, Long chatRoomId, Long senderId, String message, LocalDateTime sendTime) {
        this.id = id;
        this.chatRoomId = chatRoomId;
        this.senderId = senderId;
        this.message = message;
        this.sendTime = sendTime;
    }
}
