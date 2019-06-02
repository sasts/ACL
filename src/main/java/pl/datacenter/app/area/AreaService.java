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
        return areaRepository.findOne(id);
    }

    public Area update(Area area) {
        return areaRepository.save(area);
    }

    public void delete(Long id) {
        areaRepository.delete(id);
    }

    public List<Area> findAll() {
        return areaRepository.findByOrderByName();
    }




}
