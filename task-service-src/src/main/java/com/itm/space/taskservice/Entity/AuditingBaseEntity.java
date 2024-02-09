package com.itm.space.taskservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.security.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditingBaseEntity extends BaseEntity{

    @CreatedDate
    @Column(name = "created", nullable = false)
    private Timestamp created;

    @LastModifiedDate
    @Column(name = "updated")
    private Timestamp updated;

    @CreatedBy
    @Column(name = "created_by", nullable = false)
    private UUID created_by;

    @LastModifiedBy
    @Column(name = "updated_by")
    private UUID updated_by;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AuditingBaseEntity that = (AuditingBaseEntity) o;
        return Objects.equals(created, that.created) && Objects.equals(updated, that.updated)&&Objects.equals(created_by, that.created_by) && Objects.equals(updated_by, that.updated_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), created, updated, created_by, updated_by);
    }

    @Override
    public String toString() {
        return "AuditingBaseEntity{" +
                "created=" + created +
                ", updated=" + updated +
                "created_by=" + created_by +
                ", updated_by=" + updated_by +
                '}';
    }
}
