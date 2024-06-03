package slur.teamslur.backend.Domain.Message.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slur.teamslur.backend.Domain.Message.DTO.ChatRoom;
import slur.teamslur.backend.Domain.Message.DTO.RequestChatRoom;
import slur.teamslur.backend.Domain.Message.DTO.ResponseChatRoom;
import slur.teamslur.backend.Domain.Message.Service.ChatRoomService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;


    // 모든 채팅방 목록 반환
    @GetMapping("/chat")
    @ResponseBody
    public List<ChatRoom> room() {
        List<ChatRoom> list = chatRoomService.findAllRoom();
        return list;
    }

    @GetMapping("/chat/{room_id}")
    public ResponseEntity<ResponseChatRoom> getChatRoom(@PathVariable("room_id") Long roomId) {
        ResponseChatRoom responseChatRoom = chatRoomService.getChatRoom(roomId);

        return ResponseEntity.status(HttpStatus.OK).body(responseChatRoom);
    }


    // 채팅방 생성
    @PostMapping("/chat")
    public ResponseEntity<Long> createChatRoom(@RequestBody RequestChatRoom requestChatRoom) {
        Long chatRoomId = chatRoomService.createChatRoom(requestChatRoom);

        return ResponseEntity.status(HttpStatus.CREATED).body(chatRoomId);
    }


    @GetMapping("/chat/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable int roomId) {
        return chatRoomService.findRoomById(roomId);
    }
}