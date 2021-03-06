package pl.datacenter.app.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByOrderByName();

    Company findByName(String name);


}
