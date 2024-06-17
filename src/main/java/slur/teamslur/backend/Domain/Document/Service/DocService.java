package slur.teamslur.backend.Domain.Document.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import slur.teamslur.backend.Domain.Document.DTO.RequestCreateDocDTO;
import slur.teamslur.backend.Domain.Document.Entity.DocEntity;
import slur.teamslur.backend.Domain.Document.Repository.DocRepository;

import java.util.Optional;

@Service
public class DocService {
    private final DocRepository docRepository;
    @Autowired
    DocService(DocRepository docRepository){this.docRepository=docRepository;}

    public ResponseEntity<DocEntity> findDocByDocId(long docId) {
        Optional<DocEntity> docEntity = docRepository.findById(docId);
        if(docEntity.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(docEntity.get());

    }

    public DocEntity createDoc(RequestCreateDocDTO docDTO) {
        DocEntity docEntity = docRepository.save(
                DocEntity.builder()
                        .projId(docDTO.getProjId())
                        .parentId(docDTO.getParentId())
                        .title(docDTO.getTitle())
                        .content(docDTO.getContent())
                        .dataId(docDTO.getDataId())
                        .docPath("")
                        .build()
        );
        return docEntity;
    }
}
