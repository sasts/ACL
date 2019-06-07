package pl.datacenter.app.unique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.datacenter.app.company.CompanyService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CompanyUniqueValidator implements ConstraintValidator<UniqueCompany ,String> {

    @Autowired
    private CompanyService companyService;

    @Override
    public void initialize(UniqueCompany unique) {
        unique.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (companyService != null && companyService.existsByName(name)) {
            return false;
        }
        return true;
    }
}
