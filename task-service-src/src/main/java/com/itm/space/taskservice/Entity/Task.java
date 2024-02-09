package com.itm.space.taskservice.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tasks")

public class Task extends AuditingBaseEntity {

        @Column(name = "title", nullable = false)
        private String title;

        @Column(name = "text", nullable = false)
        private String text;

        @Column(name = "is_archived", nullable = false)
        private boolean is_archived = false;

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                Task that = (Task) o;
                return Objects.equals(title, that.title) && Objects.equals(text, that.text) && (is_archived == that.is_archived);
        }

        @Override
        public int hashCode() {
                return Objects.hash(super.hashCode(), title, text,is_archived);
        }
}
