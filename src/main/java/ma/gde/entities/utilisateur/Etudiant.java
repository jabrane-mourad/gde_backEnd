package ma.gde.entities.utilisateur;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.entities.data.Absence;
import ma.gde.entities.data.Note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Etudiant extends Utilisateur {
    @Column
    private String codeMasar;
    @Column
    private Niveau niveau;

    @OneToMany(targetEntity = Note.class, mappedBy = "etudiant")
    private Collection<Note> notes = new ArrayList<>();

    @OneToMany(targetEntity = Absence.class, mappedBy = "etudiant")
    private Collection<Absence> absences = new ArrayList<>();

    public Etudiant(Long id, String nom, String prenom, Date dateNaissance, String email, String password, String codeMasar, Niveau niveau) {
        super(id, nom, prenom, dateNaissance, email, Role.ROLE_ETUDIANT, password);
        this.codeMasar = codeMasar;
        this.niveau = niveau;
    }
}
