package ma.gde.entities.utilisateur;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.entities.Module;
import ma.gde.enun.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Enseignant extends Utilisateur implements Serializable {
    @Column
    private String numeroSom;
    @OneToMany(targetEntity = Module.class, mappedBy = "enseignant")
    @JsonIgnore
    private Collection<Module> modules = new ArrayList<>();

    public Enseignant(Long id, String nom, String prenom, Date dateNaissance, String email, String password, String numeroSom) {
        super(id, nom, prenom, dateNaissance, email, Role.ROLE_ENSEIGNANT, password);
        this.numeroSom = numeroSom;
    }
}
