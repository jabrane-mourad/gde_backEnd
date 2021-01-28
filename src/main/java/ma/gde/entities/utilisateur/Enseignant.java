package ma.gde.entities.utilisateur;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.entities.Module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Enseignant extends Utilisateur {
    @Column
    private String numero_som;
    @OneToMany(targetEntity = Module.class, mappedBy = "enseignant")
    private Collection<Module> modules = new ArrayList<>();

    public Enseignant(Long id, String nom, String prenom, Date dateNaissance, String email, Role role, String password, String numero_som) {
        super(id, nom, prenom, dateNaissance, email, role, password);
        this.numero_som = numero_som;
    }
}
