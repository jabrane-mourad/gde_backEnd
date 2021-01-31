package ma.gde.dao;

import ma.gde.entities.Demande;
import ma.gde.entities.Semestre;
import ma.gde.enun.Filiere;
import ma.gde.enun.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface DemandeRepo extends JpaRepository<Demande, Long> {
    @Query(value = "SELECT d FROM Demande d where d.etudiant.codeMasar=?1")
    List<Demande> findDemandeByEtudiantInformation(
            @Param("codeMasar") String codeMasar
    );
}
