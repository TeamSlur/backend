package slur.teamslur.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "document")
public class DocEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "proj_id", nullable = false)
    private int projId;
    private int dataId;
    private Integer parentId;
    private String title;
    private String content;
    private String docPath;
}

