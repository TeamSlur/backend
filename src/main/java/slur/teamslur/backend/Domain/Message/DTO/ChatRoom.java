package slur.teamslur.backend.Domain.Message.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import slur.teamslur.backend.Domain.Message.Entity.ChatRoomEntity;

@Data
@NoArgsConstructor
public class ChatRoom {
    private int projId;

    public static ChatRoom create(int projId) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.projId=projId;
        return chatRoom;
    }

    protected ChatRoom(ChatRoomEntity chatRoomEntity) {
        this.projId = chatRoomEntity.getProjId();
    }

}