package ma.gde.dao;

import ma.gde.entities.utilisateur.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@org.springframework.data.rest.webmvc.RepositoryRestController
@org.springframework.web.bind.annotation.RestController
public interface AdministrateurRepo extends JpaRepository<Administrateur, Long> {
}
