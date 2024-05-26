package slur.teamslur.backend.Domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

//    UserEntity findByUser_email(String email);
}
