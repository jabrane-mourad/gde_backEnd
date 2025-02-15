package ma.gde.service.interfaces;

import ma.gde.entities.Semestre;
import ma.gde.entities.Utilisateur;
import ma.gde.enun.Filiere;

import java.util.List;

public interface UtilisateurServiceIn {

    public Utilisateur save(Utilisateur user);

    public Utilisateur getUtilisateur(String username);
    public List<Semestre> getEmploisBySemestreAndFiliere(String semestre, Filiere filiere);

}
