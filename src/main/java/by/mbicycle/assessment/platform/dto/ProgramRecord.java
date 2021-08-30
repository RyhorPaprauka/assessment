package by.mbicycle.assessment.platform.dto;

import java.util.UUID;

public record ProgramRecord(
        UUID id,
        String link,
        String title,
        Integer index,
        Boolean isCompleted,
        Boolean shouldDecrease,
        Integer decreaseTimes) {
}
