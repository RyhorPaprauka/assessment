package by.mbicycle.assessment.platform.resolver;

import by.mbicycle.assessment.platform.dto.PlanRecord;
import by.mbicycle.assessment.platform.service.PlanService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import javassist.tools.web.BadHttpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanQueryResolver implements GraphQLQueryResolver {

    private final PlanService planService;

    public PlanRecord getPlan(String title) throws BadHttpRequest {
        return planService.findByTitle(title)
                .orElseThrow(BadHttpRequest::new);
    }
}
