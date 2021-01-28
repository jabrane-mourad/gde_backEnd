package ma.gde.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.entities.data.Absence;
import ma.gde.entities.data.Note;
import ma.gde.entities.utilisateur.Enseignant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @ManyToOne @JoinColumn( nullable=false)
    private Semestre semestre;

    @OneToMany(targetEntity = Cours.class,mappedBy = "module")
    private Collection<Cours> elements=new ArrayList<>();

    @OneToMany(targetEntity = Note.class,mappedBy = "module")
    private Collection<Note> notes=new ArrayList<>();

    @OneToMany(targetEntity = Absence.class, mappedBy = "module")
    private Collection<Absence> absences = new ArrayList<>();

    @ManyToOne
    @JoinColumn( nullable=false)
    private Enseignant enseignant;

}
