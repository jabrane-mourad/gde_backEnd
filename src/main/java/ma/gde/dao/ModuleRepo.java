package ma.gde.dao;

import ma.gde.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ModuleRepo extends JpaRepository<Module, Long> {

}
