package by.mbicycle.assessment.platform.controller;

import by.mbicycle.assessment.platform.dto.NodeRecord;
import by.mbicycle.assessment.platform.service.NodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static by.mbicycle.assessment.platform.controller.util.UrlPath.BASE;
import static by.mbicycle.assessment.platform.controller.util.UrlPath.NODE;

@RestController
@RequestMapping(BASE + NODE)
@RequiredArgsConstructor
public class NodeController {

    private final NodeService nodeService;

    @PostMapping
    private ResponseEntity<NodeRecord> createNode(@RequestBody NodeRecord nodeRecord) {
        return ResponseEntity.ok(nodeService.createNode(nodeRecord));
    }
}
