package ma.gde.entities.utilisateur;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Administrateur extends Utilisateur {
    @Column
    private String idAdmin;

    public Administrateur(Long id, String nom, String prenom, Date dateNaissance, String email, Role role, String password, String idAdmin) {
        super(id, nom, prenom, dateNaissance, email, role, password);
        this.idAdmin = idAdmin;
    }
}
