package by.mbicycle.assessment.platform.database.entity;

import by.mbicycle.assessment.platform.database.entity.enam.NodePriority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "node")
@NamedEntityGraph(name = "Node.withPrograms", attributeNodes = @NamedAttributeNode("programs"))
public class NodeEntity implements BaseEntity<UUID> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "text")
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private NodePriority priority;

    @Column(name = "disable_drag", nullable = false)
    private Boolean isDisableDrag;

    @Column(name = "outputs", nullable = false)
    private String outputs;

    @Column(name = "coordinate_x", nullable = false)
    private Integer coordinateX;

    @Column(name = "coordinate_y", nullable = false)
    private Integer coordinateY;

    @OneToMany(
            mappedBy = "node",
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private Set<ProgramEntity> programs = new HashSet<>();
}
