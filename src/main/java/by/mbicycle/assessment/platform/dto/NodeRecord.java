package by.mbicycle.assessment.platform.dto;

import java.util.List;
import java.util.UUID;

public record NodeRecord(
        UUID id,
        String title,
        List<Integer> coordinates,
        String outputs,
        Boolean isDisableDrag,
        NodeDataRecord data) {
}
