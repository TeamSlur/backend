package slur.teamslur.backend.Domain.Message.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import slur.teamslur.backend.Domain.Message.DTO.ChatRoom;

@Getter
@Entity
public class ChatRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int projId;
}

