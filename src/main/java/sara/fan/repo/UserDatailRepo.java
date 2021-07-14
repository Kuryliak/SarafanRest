package sara.fan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sara.fan.domain.User;

public interface UserDatailRepo extends JpaRepository<User,String> {
}
