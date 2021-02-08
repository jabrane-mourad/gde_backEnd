package ma.gde.dao;

import ma.gde.enun.Filiere;
import ma.gde.entities.Semestre;
import ma.gde.enun.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface SemestreRepo extends JpaRepository<Semestre, Long> {

    @Query(value = "SELECT s FROM Semestre s where s.nom=?1 and s.niveau=?2 and s.filiere=?3")
    Semestre findByEtudiantInformation(
            @Param("nom") String nom,
            @Param("niveau") Niveau niveau,
            @Param("filiere") Filiere filiere
    );

    @Query(value = "SELECT s FROM Semestre s where s.nom=?1 and s.filiere=?2")
    List<Semestre> getEmploisBySemestreAndFiliere(String semestre, Filiere filiere);
}
