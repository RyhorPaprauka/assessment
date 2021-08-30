package by.mbicycle.assessment.platform.service;

import by.mbicycle.assessment.platform.database.repo.PlanRepository;
import by.mbicycle.assessment.platform.dto.PlanRecord;
import by.mbicycle.assessment.platform.mapper.PlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    private final PlanMapper planMapper;

    public Optional<PlanRecord> findByTitle(String title) {
        return planRepository.findByTitle(title)
                .map(planMapper::toRecord);
    }
}
