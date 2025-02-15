package ma.gde.dao;

import ma.gde.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
    Etudiant getEtudiantByCodeMasar(String codeMasar);
}
