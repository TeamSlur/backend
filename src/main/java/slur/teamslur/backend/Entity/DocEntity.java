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
    @Column(name = "proj_id")
    private int projId;
    @Column(name = "data_id")
    private int dataId;
    @Column(name = "parent_id")
    private int parent_id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "doc_path")
    private String docPath;
}
