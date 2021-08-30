package by.mbicycle.assessment.platform.mapper;

import by.mbicycle.assessment.platform.database.entity.ProgramEntity;
import by.mbicycle.assessment.platform.dto.ProgramRecord;
import org.mapstruct.Mapper;

@Mapper
public interface ProgramMapper {

    ProgramRecord toRecord(ProgramEntity program);
}
