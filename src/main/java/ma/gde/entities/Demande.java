package ma.gde.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.enun.Etat;
import ma.gde.enun.TypeDemande;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Demande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TypeDemande typeDemande;
    private Etat etat;
    private String description;
    private String justification;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Etudiant etudiant;

    public Demande(Long id, TypeDemande typeDemande, String description, Etudiant etudiant) {
        this.id = id;
        this.typeDemande = typeDemande;
        this.description = description;
        this.etudiant = etudiant;
    }
}
