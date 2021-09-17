package by.mbicycle.assessment.platform.service;

import by.mbicycle.assessment.platform.database.repo.NodeRepository;
import by.mbicycle.assessment.platform.dto.NodeRecord;
import by.mbicycle.assessment.platform.mapper.NodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NodeService {

    private final NodeRepository nodeRepository;
    private final NodeMapper nodeMapper;

    public NodeRecord createNode(NodeRecord nodeRecord) {
        return nodeMapper.toRecord(nodeRepository.save(nodeMapper.toEntity(nodeRecord)));
    }
}
