package com.unchk.unchk.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unchk.unchk.models.Module;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
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

public class User extends GlobalModel {

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

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @JsonIgnoreProperties({ "user", "module" })
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Groupe> groupes;

    // @ManyToAny
    // @JoinTable(name = "user_modules", joinColumns = @JoinColumn(name =
    // "user_id"), inverseJoinColumns = @JoinColumn(name = "module_id"))
    // private Set<Module> modules;

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
}
