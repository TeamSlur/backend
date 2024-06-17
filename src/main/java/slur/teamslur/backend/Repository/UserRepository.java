package slur.teamslur.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slur.teamslur.backend.Entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

//    UserEntity findByUser_email(String email);
    Optional<UserEntity> findById(String id);

    // 메소드 이름 규칙이용하여 Join

}