package slur.teamslur.backend.Domain.Issue.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slur.teamslur.backend.Domain.Issue.Entity.IssueEntity;
import slur.teamslur.backend.Domain.User.Entity.UserEntity;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<IssueEntity,Integer> {
    UserEntity findById(String id){
        retu;
    }
}
