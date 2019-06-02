package pl.datacenter.app.visitor;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.datacenter.app.company.Company;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class VisitorService {

    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public void create(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    public Visitor read(Long id) {
        return visitorRepository.findOne(id);
    }

    public void update(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    public void delete(Long id) {
        visitorRepository.delete(id);
    }

    public List<Visitor> findAll() {
        return visitorRepository.findAll();
    }

    public List<Visitor> findAllByCompanyId(Long id) {
        return visitorRepository.findByCompanyIdOrderByFirstName(id);
    }


}
