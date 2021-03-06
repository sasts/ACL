package pl.datacenter.app.company;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.datacenter.app.visitor.Visitor;

import java.util.List;

@Service
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void create(Company company) {
        companyRepository.save(company);
    }

    public Company read(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public void update(Company company) {
        companyRepository.save(company);
    }

    public void delete(Long id) {
        companyRepository.deleteById(id);
    }

    public List<Company> findAll() {
        return companyRepository.findByOrderByName();
    }

    public Company readWithVisitors(Long id) {
        Company company = read(id);
        Hibernate.initialize(company.getVisitors());
        return company;
    }

    public boolean existsByName(String name) {
        boolean companyExists = true;

        if(companyRepository.findByName(name) == null) {
            companyExists = false;
        }
        return companyExists;
    }

}
