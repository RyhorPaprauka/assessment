package by.mbicycle.assessment.platform.dto;

import java.util.List;

public record PlanRecord(String title, List<NodeRecord> nodes, List<LinkRecord> links) {
}
