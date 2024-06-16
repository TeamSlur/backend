package slur.teamslur.backend.Domain.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.Project.DTO.MemberProjectDTO;
import slur.teamslur.backend.Domain.Project.Entity.MemberEntity;
import slur.teamslur.backend.Domain.Project.Repository.MemberRepository;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberEntity> getMembersByProjectId(int projId) {
        return memberRepository.findByProjId(projId);
    }

    public MemberEntity modifyNicknameByUserId(int projId, String userId) {
        MemberEntity member = memberRepository.findByProjIdAndUserId(projId,userId);
        member.setNickName("Test");
        memberRepository.save(member);
        return member;
    }
}
