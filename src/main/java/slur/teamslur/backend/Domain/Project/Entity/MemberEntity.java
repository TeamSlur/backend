package slur.teamslur.backend.Domain.Project.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "proj_id")
    private int projId;

    @Column(name = "nickname")
    private String nickName;

    // 생성자, getter, setter 등 필요한 부분은 생략
}

