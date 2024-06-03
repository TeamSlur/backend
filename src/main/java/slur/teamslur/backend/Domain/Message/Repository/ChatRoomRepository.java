package slur.teamslur.backend.Domain.Message.Repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import slur.teamslur.backend.Domain.Message.DTO.ChatRoom;
import slur.teamslur.backend.Domain.Message.DTO.RequestChatRoom;
import slur.teamslur.backend.Domain.Message.Entity.ChatRoomEntity;

import java.util.*;

@Repository
public class ChatRoomRepository {
    private Map<Integer, ChatRoomEntity> chatRoomMap;

    @PostConstruct
    private void init() {
        chatRoomMap = new LinkedHashMap<>();
    }

/*    public List<ChatRoom> findAllRoom() {
        List<ChatRoom> chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);     //최신 순으로 정렬
        return chatRooms;
    }

    public ChatRoom findRoomById(int id) {
        return chatRoomMap.get(id);
    }

    public ChatRoom createChatRoom(int projId) {
        ChatRoom chatRoom = ChatRoom.create(projId);
        chatRoomMap.put(chatRoom.getProjId(), chatRoom);
        return chatRoom;
    }*/

    public void save(ChatRoomEntity entity) {
    }

    public void findRoomById(int roomId) {
    }
}
