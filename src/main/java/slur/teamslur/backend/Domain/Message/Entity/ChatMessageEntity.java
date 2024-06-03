package slur.teamslur.backend.Domain.Message.Entity;

import jakarta.persistence.*;
import org.aspectj.lang.annotation.control.CodeGenerationHint;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_message")
public class ChatMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int projId;
    private String userId;
    private String content;
    private LocalDateTime time;
}
