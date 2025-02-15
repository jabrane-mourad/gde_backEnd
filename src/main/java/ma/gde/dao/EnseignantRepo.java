package ma.gde.dao;

import ma.gde.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface EnseignantRepo extends JpaRepository<Enseignant, Long> {
}
