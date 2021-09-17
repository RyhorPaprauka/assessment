package by.mbicycle.assessment.platform.mapper;

import by.mbicycle.assessment.platform.database.entity.NodeEntity;
import by.mbicycle.assessment.platform.database.entity.enam.NodePriority;
import by.mbicycle.assessment.platform.dto.NodeDataRecord;
import by.mbicycle.assessment.platform.dto.NodeRecord;
import by.mbicycle.assessment.platform.dto.OutputRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {ProgramMapper.class})
public interface NodeMapper {

    @Mapping(target = "coordinates", expression = "java(toCoordinates(nodeEntity))")
    @Mapping(target = "data", expression = "java(toDataRecord(nodeEntity))")
    NodeRecord toRecord(NodeEntity nodeEntity);

    @Mapping(target = "coordinateX", expression = "java(nodeRecord.coordinates().get(0))")
    @Mapping(target = "coordinateY", expression = "java(nodeRecord.coordinates().get(1))")
    @Mapping(target = "text", expression = "java(nodeRecord.data().text())")
    @Mapping(target = "priority", expression = "java(toNodePriority(nodeRecord))")
    NodeEntity toEntity(NodeRecord nodeRecord);

    NodeDataRecord toDataRecord(NodeEntity entity);

    default List<Integer> toCoordinates(NodeEntity entity) {
        return List.of(entity.getCoordinateX(), entity.getCoordinateY());
    }

    default String toPriorityString(NodePriority priority) {
        return priority.getValue();
    }

    default List<OutputRecord> parseOutput(String outputs) throws JsonProcessingException {
        return List.of(new ObjectMapper().readValue(outputs, OutputRecord[].class));
    }

    default String writeOutput(List<OutputRecord> outputs) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(outputs);
    }

    default NodePriority toNodePriority(NodeRecord nodeRecord) {
        return NodePriority.valueOf(nodeRecord.data().priority());
    }
}
