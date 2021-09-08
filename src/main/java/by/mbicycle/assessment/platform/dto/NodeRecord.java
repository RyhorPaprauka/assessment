package by.mbicycle.assessment.platform.dto;

import java.util.List;
import java.util.UUID;

public record NodeRecord(
        UUID id,
        Integer index,
        String content,
        List<Integer> coordinates,
        List<OutputRecord> outputs,
        Boolean isDisableDrag,
        NodeDataRecord data) {
}
