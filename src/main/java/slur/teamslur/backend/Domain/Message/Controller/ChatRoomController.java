package slur.teamslur.backend.Domain.Message.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import slur.teamslur.backend.Domain.Message.DTO.ChatRoom;
import slur.teamslur.backend.Domain.Message.Repository.ChatRoomRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;


    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        List<ChatRoom> list = chatRoomRepository.findAllRoom();
        return list;
    }


    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String user1) {
        return chatRoomRepository.createChatRoom(user1);
    }


    // 특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatRoomRepository.findRoomById(roomId);
    }
}