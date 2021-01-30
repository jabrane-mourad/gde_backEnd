package ma.gde.entities.utilisateur;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Administrateur extends Utilisateur {
    @Column
    private String idAdmin;

    public Administrateur(Long id, String nom, String prenom, Date dateNaissance, String email, String password, String idAdmin) {
        super(id, nom, prenom, dateNaissance, email,Role.ROLE_ADMINISTRATEUR, password);
        this.idAdmin = idAdmin;
    }
}
