package by.mbicycle.assessment.platform.controller;

import by.mbicycle.assessment.platform.dto.PlanRecord;
import by.mbicycle.assessment.platform.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static by.mbicycle.assessment.platform.controller.util.UrlPath.BASE;
import static by.mbicycle.assessment.platform.controller.util.UrlPath.PLAN;

@RestController
@RequestMapping(BASE + PLAN)
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @GetMapping("/{title}")
    private ResponseEntity<PlanRecord> findOne(@PathVariable String title) {
        return planService.findByTitle(title)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
}
