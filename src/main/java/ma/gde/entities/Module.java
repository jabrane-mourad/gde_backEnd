package ma.gde.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.entities.data.Absence;
import ma.gde.entities.data.Note;
import ma.gde.entities.utilisateur.Enseignant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String cleCours;
    private String source;
    private int nbrHeure;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Semestre semestre;

    @OneToMany(targetEntity = Note.class, mappedBy = "module")
    private Collection<Note> notes = new ArrayList<>();

    @OneToMany(targetEntity = Absence.class, mappedBy = "module")
    private Collection<Absence> absences = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    private Enseignant enseignant;

}
