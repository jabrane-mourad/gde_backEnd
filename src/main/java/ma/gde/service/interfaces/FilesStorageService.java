package ma.gde.service.interfaces;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesStorageService {
    public void init();

    public void save(MultipartFile file,String motCle,Long idCours,String url);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
}
