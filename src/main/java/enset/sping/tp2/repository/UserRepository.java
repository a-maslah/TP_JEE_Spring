package enset.sping.tp2.repository;

import enset.sping.tp2.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
