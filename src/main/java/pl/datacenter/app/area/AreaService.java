package pl.datacenter.app.area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AreaService {

    private final AreaRepository areaRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public void create(Area area) {
        areaRepository.save(area);
    }

    public Area read(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    public Area update(Area area) {
        return areaRepository.save(area);
    }

    public void delete(Long id) {
        areaRepository.deleteById(id);
    }

    public List<Area> findAll() {
        return areaRepository.findByOrderByName();
    }

    public boolean existsByName(String name) {
        boolean areaExists = true;

        if(areaRepository.findByName(name) == null) {
            areaExists = false;
        }
        return areaExists;
    }




}
