package slur.teamslur.backend.Domain.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slur.teamslur.backend.Domain.Project.Entity.MemberEntity;
import slur.teamslur.backend.Domain.Project.Service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/projects/{projID}/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("")
    public ResponseEntity<List<MemberEntity>> getMembersByProjectId(@PathVariable("projID") int projId) {
        List<MemberEntity> members = memberService.getMembersByProjectId(projId);
        return ResponseEntity.ok(members);
    }
}
