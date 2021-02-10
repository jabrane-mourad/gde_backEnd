package ma.gde.dao;

import ma.gde.entities.Absence;
import ma.gde.enun.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbsenceRepo extends JpaRepository<Absence,Long> {
    @Query(value = "SELECT a FROM Absence a where a.etudiant.codeMasar=?1 and a.etudiant.niveau=?2")
    List<Absence> findAbsenceByEtudiantInformation(
            @Param("codeMasar") String codeMasar,
            @Param("niveau") Niveau niveau
    );
}
