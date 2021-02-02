package ma.gde.dao;

import ma.gde.entities.Demande;
import ma.gde.entities.Semestre;
import ma.gde.enun.Etat;
import ma.gde.enun.Filiere;
import ma.gde.enun.Niveau;
import ma.gde.enun.TypeDemande;
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

    @Query(value = "SELECT d FROM Demande d where d.typeDemande=?1 and d.etat=?2 ")
    List<Demande> getDemandesByTypeAndEtat(
            @Param("typeDemande") TypeDemande typeDemande,
            @Param("etatDemande") Etat etatDemande
    );
}
