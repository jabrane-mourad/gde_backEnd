package ma.gde.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.enun.Filiere;
import ma.gde.enun.Niveau;
import ma.gde.enun.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Etudiant extends Utilisateur implements Serializable {
    @Column
    private String codeMasar;
    @Column
    private Niveau niveau;
    @Column
    private Filiere filiere;

    @OneToMany(targetEntity = Note.class, mappedBy = "etudiant")
    private Collection<Note> notes = new ArrayList<>();

    @OneToMany(targetEntity = Absence.class, mappedBy = "etudiant")
    private Collection<Absence> absences = new ArrayList<>();

    @OneToMany(targetEntity = Demande.class, mappedBy = "etudiant",fetch = FetchType.LAZY)
    private Collection<Demande> demandes = new ArrayList<>();


    public Etudiant(Long id, String nom, String prenom, Date dateNaissance, String email, String password, String codeMasar, Niveau niveau,Filiere filiere) {
        super(id, nom, prenom, dateNaissance, email, Role.ROLE_ETUDIANT, password);
        this.codeMasar = codeMasar;
        this.niveau = niveau;
        this.filiere=filiere;
    }
}
