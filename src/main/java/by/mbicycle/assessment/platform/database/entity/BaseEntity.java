package by.mbicycle.assessment.platform.database.entity;

import java.io.Serializable;

public interface BaseEntity<PK extends Serializable> {

    PK getId();
}
