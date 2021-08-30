package by.mbicycle.assessment.platform.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
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
@Table(name = "plan")
@NamedEntityGraph(name = "Plan.details",
        attributeNodes = {
                @NamedAttributeNode("links"),
                @NamedAttributeNode(value = "nodes", subgraph = "Nodes.withPrograms"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "Nodes.withPrograms",
                        attributeNodes = {
                                @NamedAttributeNode("programs")
                        }
                )
        }
)
public class PlanEntity implements BaseEntity<UUID> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "plan_node",
            joinColumns = @JoinColumn(name = "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "node_id")
    )
    @Builder.Default
    private Set<NodeEntity> nodes = new HashSet<>();

    @OneToMany(
            mappedBy = "plan",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private Set<LinkEntity> links = new HashSet<>();
}
