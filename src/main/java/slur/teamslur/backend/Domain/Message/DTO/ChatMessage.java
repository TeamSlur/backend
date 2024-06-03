package slur.teamslur.backend.Domain.Message.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ChatMessage {
    public enum MessageType {
        ENTER, TALK, EXIT;
    }
    private MessageType type;
    private int id;
    private int projId;
    private String userId;
    private String message;
    private LocalDate time;
}