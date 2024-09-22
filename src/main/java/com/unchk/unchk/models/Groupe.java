package com.unchk.unchk.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

public class Groupe extends GlobalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private Integer heureTotalEffectue;

    @Column(nullable = false)
    private Integer heureTotalNonEffectue;

    @JsonIgnoreProperties("groupes")
    @ManyToOne()
    private Module module;

    @JsonIgnoreProperties("groupes")
    @ManyToOne
    private UserApp user;

    @JsonIgnoreProperties("groupe")
    @OneToMany(mappedBy = "groupe", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Effectuer> effectues;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

}
