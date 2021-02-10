package ma.gde.dao;

import ma.gde.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String username);
}
