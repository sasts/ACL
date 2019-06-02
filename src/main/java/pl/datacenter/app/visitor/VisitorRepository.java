package pl.datacenter.app.visitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {


    List<Visitor> findByCompanyIdOrderByFirstName(Long id);


}
