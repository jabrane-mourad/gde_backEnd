package ma.gde.dao;

import ma.gde.entities.data.Note;
import ma.gde.entities.utilisateur.Etudiant;
import ma.gde.enun.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
    Etudiant getEtudiantByCodeMasar(String codeMasar);
}
