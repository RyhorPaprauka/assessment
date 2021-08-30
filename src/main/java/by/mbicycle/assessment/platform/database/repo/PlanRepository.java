package by.mbicycle.assessment.platform.database.repo;

import by.mbicycle.assessment.platform.database.entity.PlanEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlanRepository extends JpaRepository<PlanEntity, UUID> {

    @EntityGraph(value = "Plan.details")
    Optional<PlanEntity> findByTitle(String title);
}
