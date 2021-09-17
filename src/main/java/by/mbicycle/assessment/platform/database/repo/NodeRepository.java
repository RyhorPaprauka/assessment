package by.mbicycle.assessment.platform.database.repo;

import by.mbicycle.assessment.platform.database.entity.NodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NodeRepository extends JpaRepository<NodeEntity, UUID> {

}
