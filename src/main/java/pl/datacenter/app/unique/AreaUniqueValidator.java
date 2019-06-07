package pl.datacenter.app.unique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.datacenter.app.area.AreaService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class AreaUniqueValidator implements ConstraintValidator<UniqueArea ,String> {

    @Autowired
    private AreaService areaService;

    @Override
    public void initialize(UniqueArea unique) {
        unique.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (areaService != null && areaService.existsByName(name)) {
            return false;
        }
        return true;
    }
}
