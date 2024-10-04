package com.unchk.unchk.models;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Tuteur extends GlobalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Integer heureTotal;

    private Integer heureTotalEffectue;

    private Integer heureTotalNonEffectue;

    private Boolean reconduit;

    @JsonIgnoreProperties({ "tuteur", "groupes", "modules" })
    @OneToOne
    private UserApp user;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

}
