package slur.teamslur.backend.Domain.Document.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateDocDTO {
    private int projId;
    private int dataId = 101;
    private Integer parentId;
    private String title = "제목없음";
    private String content = "내용을 입력해주세요";
}
