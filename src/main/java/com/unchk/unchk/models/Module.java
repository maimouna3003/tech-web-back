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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

public class Module extends GlobalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(nullable = false)
    private Integer heure;

    @Column(nullable = false)
    private Integer semaine;

    @JsonIgnoreProperties({ "module" })
    @OneToMany(mappedBy = "module", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Groupe> groupes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "groupes", "modules" })
    @JoinTable(name = "affectation", joinColumns = @JoinColumn(name = "module_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserApp> users;

    @JsonIgnoreProperties("module")
    @OneToMany(mappedBy = "module", fetch = FetchType.EAGER)
    private List<Seance> seances;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

}
