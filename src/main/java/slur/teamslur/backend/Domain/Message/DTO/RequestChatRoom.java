package slur.teamslur.backend.Domain.Message.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import slur.teamslur.backend.Domain.Message.Entity.ChatRoomEntity;

@Getter
@NoArgsConstructor
public class RequestChatRoom {
    public ChatRoomEntity toEntity() {
        ChatRoomEntity chatRoomEntity = new ChatRoomEntity();
        return chatRoomEntity;
    }
}
