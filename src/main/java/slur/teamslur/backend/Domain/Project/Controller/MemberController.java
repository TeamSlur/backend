package slur.teamslur.backend.Domain.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slur.teamslur.backend.Domain.Project.Entity.MemberEntity;
import slur.teamslur.backend.Domain.Project.Service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/projects/{projID}")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 해당 프로젝트 내 멤버 조회
    @GetMapping("/members")
    public ResponseEntity<List<MemberEntity>> getMembersByProjectId(@PathVariable("projID") int projId) {
        List<MemberEntity> members = memberService.getMembersByProjectId(projId);
        return ResponseEntity.ok(members);
    }

    @PutMapping("/members/{userID}")
    public ResponseEntity<MemberEntity> modifyNicknameByUserId(
            @PathVariable("projID") int projId,
            @PathVariable("userID") String userID) {
        MemberEntity member = memberService.modifyNicknameByUserId(projId, userID);
        return ResponseEntity.ok(member);
    }

}
