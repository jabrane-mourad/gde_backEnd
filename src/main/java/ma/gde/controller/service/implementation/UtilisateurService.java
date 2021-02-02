package ma.gde.controller.service.implementation;

import ma.gde.dao.UtilisateurRepo;
import ma.gde.entities.utilisateur.Utilisateur;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    private UtilisateurRepo utilisateurRepo;
    private PasswordEncoder bcryptEncoder;

    public UtilisateurService(UtilisateurRepo utilisateurRepo, PasswordEncoder bcryptEncoder) {
        this.utilisateurRepo = utilisateurRepo;
        this.bcryptEncoder = bcryptEncoder;
    }


    public Utilisateur save(Utilisateur user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return utilisateurRepo.save(user);
    }


    public Utilisateur getUtilisateur(String username) {
        return utilisateurRepo.findByEmail(username);
    }
}
