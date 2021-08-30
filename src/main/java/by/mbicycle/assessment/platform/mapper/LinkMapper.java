package by.mbicycle.assessment.platform.mapper;

import by.mbicycle.assessment.platform.database.entity.LinkEntity;
import by.mbicycle.assessment.platform.dto.LinkRecord;
import org.mapstruct.Mapper;

@Mapper
public interface LinkMapper {

    LinkRecord toRecord(LinkEntity linkEntity);
}
