package repo;

import entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Message, Long> {
}
