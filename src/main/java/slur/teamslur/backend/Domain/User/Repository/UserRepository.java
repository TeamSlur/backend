package slur.teamslur.backend.Domain.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slur.teamslur.backend.Domain.User.Entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

//    UserEntity findByUser_email(String email);
    Optional<UserEntity> findById(String id);
}
