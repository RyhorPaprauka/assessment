package by.mbicycle.assessment.platform.database.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class UserProgramId implements Serializable {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "program_id")
    private UUID programId;
}