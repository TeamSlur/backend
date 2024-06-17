package slur.teamslur.backend.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "message")
public class ChatMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int projId;
    private String userId;
    private String content;
    private LocalDateTime time;

    @Builder
    public ChatMessageEntity(int projId, String userId, String content, LocalDateTime time) {
        this.projId = projId;
        this.userId = userId;
        this.content = content;
        this.time = time;
    }
}
