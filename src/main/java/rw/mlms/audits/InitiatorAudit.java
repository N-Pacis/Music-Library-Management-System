package rw.mlms.audits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@JsonIgnoreProperties(value = {"createdBy", "updatedBy"}, allowGetters = true)
public abstract class InitiatorAudit extends TimestampAudit{

    private static final Long serialVersionUID = 1L;
    @CreatedBy
    @Column(name = "created_by")
    private UUID createdBy;

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

}

