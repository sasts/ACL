package pl.datacenter.app.file;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<DBFile, Long> {

}
