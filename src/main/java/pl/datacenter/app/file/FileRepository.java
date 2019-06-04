package pl.datacenter.app.file;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<DBFile, Long> {

    List<DBFile> findByCompanyIdOrderByFileName(Long id);

}
