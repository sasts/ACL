package pl.datacenter.app.area;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Long> {

    List<Area> findByOrderByName();

    Area findByName(String name);

}
