package slur.teamslur.backend.Domain.Document.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slur.teamslur.backend.Domain.Document.DTO.RequestCreateDocDTO;
import slur.teamslur.backend.Domain.Document.Entity.DocEntity;
import slur.teamslur.backend.Domain.Document.Service.DocService;

@RestController
@RequestMapping("/projects/{projId}/docs")
public class DocController {
    private final DocService docService;
    @Autowired
    DocController(DocService docService){this.docService=docService;}

    // 문서 생성
    @PostMapping
    public ResponseEntity<DocEntity> createDoc(@PathVariable Long projId, RequestCreateDocDTO docDTO){
        DocEntity docEntity = docService.createDoc(docDTO);
        return ResponseEntity.ok(docEntity);
    }

    // 해당 문서 데이터 조회
    @GetMapping("/{docId}")
    public ResponseEntity<DocEntity> loadDoc(@PathVariable Long projId,@PathVariable long docId){
        DocEntity docEntity = docService.findDocByDocId(docId).getBody();
        return ResponseEntity.ok(docEntity);
    }


}
