package ma.gde.dao;

import ma.gde.entities.Filiere;
import ma.gde.entities.Module;
import ma.gde.entities.utilisateur.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface ModuleRepo extends JpaRepository<Module, Long> {

}
