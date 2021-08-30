package by.mbicycle.assessment.platform.database.entity.enam;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NodePriority {

    MUST_KNOW("MustKnow"),
    GOOD_TO_KNOW("GoodToKnow"),
    POSSIBILITY("Possibility");

    private String value;
}
