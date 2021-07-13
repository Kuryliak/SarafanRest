package sara.fan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sara.fan.domain.Message;

public interface MessageRepo  extends JpaRepository<Message,Long> {
}
