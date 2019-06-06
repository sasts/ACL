package pl.datacenter.app.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public void create(Visit visit) {
        visitRepository.save(visit);
    }

    public Visit read(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    public void update(Visit visit) {
        visitRepository.save(visit);
    }

    public void delete(Long id) {
        visitRepository.deleteById(id);
    }

    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    public List<Visit> findAllWihoutLogOut() {
        return visitRepository.findByLogOutIsNull();
    }
}
