package slur.teamslur.backend.Domain.Message.Service;

import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.Message.DTO.ChatRoom;
import slur.teamslur.backend.Domain.Message.DTO.RequestChatRoom;
import slur.teamslur.backend.Domain.Message.DTO.ResponseChatRoom;
import slur.teamslur.backend.Domain.Message.Entity.ChatRoomEntity;
import slur.teamslur.backend.Domain.Message.Repository.ChatRoomRepository;

import java.util.List;

@Service
public class ChatRoomService {

    private  ChatRoomRepository chatRoomRepository;
    public Long createChatRoom(RequestChatRoom requestChatRoom) {
        ChatRoomEntity chatRoomEntity = requestChatRoom.toEntity();
        chatRoomRepository.save(requestChatRoom.toEntity());
        return null;
    }

    public ChatRoom findRoomById(int roomId) {
        chatRoomRepository.findRoomById(roomId);
        return null;
    }

    public List<ChatRoom> findAllRoom() {
        return null;
    }

    public ResponseChatRoom getChatRoom(Long clubId) {
        return null;
    }
}
