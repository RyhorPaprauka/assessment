package by.mbicycle.assessment.platform.dto;

import java.util.List;

public record NodeDataRecord(
        String priority,
        String text,
        Boolean isCompleted,
        Boolean shouldDecrease,
        List<ProgramRecord> programs) {
}
