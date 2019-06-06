package pl.datacenter.app.visitor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    List<Visitor> findByCompanyIdOrderByFirstName(Long id);

}
