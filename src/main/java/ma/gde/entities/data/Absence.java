package ma.gde.entities.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.entities.Module;
import ma.gde.entities.Semestre;
import ma.gde.entities.utilisateur.Etudiant;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @ManyToOne
    @JoinColumn( nullable=false)
    private Module module;
    @ManyToOne
    @JoinColumn( nullable=false)
    private Etudiant etudiant;
}
