package icet.edu.repository;

import icet.edu.entity.ActivityLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepository extends JpaRepository<ActivityLogEntity,Long> {
}
