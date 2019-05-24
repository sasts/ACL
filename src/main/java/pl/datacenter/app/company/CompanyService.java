package pl.datacenter.app.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return companyRepository.findOne(id);
    }

    public void update(Company company) {
        companyRepository.save(company);
    }

    public void delete(Long id) {
        companyRepository.delete(id);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

}
