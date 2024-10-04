package com.unchk.unchk.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

@Table(name = "User")
public class UserApp extends GlobalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String telephone;

    private String adresse;

    @Column(nullable = false)
    private Sexe sexe;

    @Column(nullable = false)
    private Profil profil;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties({ "user" })
    private Tuteur tuteur;

    @JsonIgnoreProperties({ "user", "module" })
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Groupe> groupes;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "users", "groupes" })
    private Set<Module> modules;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    //
    public enum Sexe {
        M, F
    }

    public enum Profil {
        Tuteur, Responsable, Admin
    }

    public enum Status {
        Actif, Pause, Arreter
    }
}
