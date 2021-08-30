package by.mbicycle.assessment.platform.mapper;

import by.mbicycle.assessment.platform.database.entity.PlanEntity;
import by.mbicycle.assessment.platform.dto.PlanRecord;
import org.mapstruct.Mapper;

@Mapper(uses = {LinkMapper.class, NodeMapper.class})
public interface PlanMapper {

    PlanRecord toRecord(PlanEntity plan);
}
