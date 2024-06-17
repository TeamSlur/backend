package slur.teamslur.backend.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDocDTO {
    private int id;
    private int projId;
    private int dataId;
    private int parentId;
    private String title;
    private String content;
    private String docPath;


}
