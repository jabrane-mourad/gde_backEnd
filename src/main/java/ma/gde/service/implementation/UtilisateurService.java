package ma.gde.service.implementation;

import ma.gde.service.interfaces.UtilisateurServiceIn;
import ma.gde.dao.SemestreRepo;
import ma.gde.dao.UtilisateurRepo;
import ma.gde.entities.Semestre;
import ma.gde.entities.Utilisateur;
import ma.gde.enun.Filiere;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService implements UtilisateurServiceIn {
    private UtilisateurRepo utilisateurRepo;
    private PasswordEncoder bcryptEncoder;
    private SemestreRepo semestreRepo;


    public UtilisateurService(UtilisateurRepo utilisateurRepo, PasswordEncoder bcryptEncoder,SemestreRepo semestreRepo) {
        this.utilisateurRepo = utilisateurRepo;
        this.bcryptEncoder = bcryptEncoder;
        this.semestreRepo=semestreRepo;
    }


    @Override
    public Utilisateur save(Utilisateur user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return utilisateurRepo.save(user);
    }


    @Override
    public Utilisateur getUtilisateur(String username) {
        return utilisateurRepo.findByEmail(username);
    }

    @Override
    public List<Semestre> getEmploisBySemestreAndFiliere(String semestre, Filiere filiere) {
        return semestreRepo.getEmploisBySemestreAndFiliere(semestre,filiere);
    }
}
