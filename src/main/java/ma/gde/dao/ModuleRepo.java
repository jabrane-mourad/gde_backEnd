package ma.gde.dao;

import ma.gde.entities.Module;
import ma.gde.entities.Semestre;
import ma.gde.enun.Filiere;
import ma.gde.enun.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface ModuleRepo extends JpaRepository<Module, Long> {
    @Query(value = "SELECT m FROM Module m where m.semestre.nom=?1 and m.semestre.niveau=?2 and m.semestre.filiere=?3 and m.cleCours=?4")
    List<Module> modulesByMotCle(
            @Param("nom") String nom,
            @Param("niveau") Niveau niveau,
            @Param("filiere") Filiere filiere,
            @Param("motCle") String motCle
    );
    @Query(value = "SELECT m FROM Module m where m.semestre.nom=?1 and m.semestre.niveau=?2 and m.semestre.filiere=?3 ")
    List<Module> findByEtudiantInformation(
            @Param("nom") String nom,
            @Param("niveau") Niveau niveau,
            @Param("filiere") Filiere filiere
    );

}
