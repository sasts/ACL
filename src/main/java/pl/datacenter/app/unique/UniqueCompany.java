package pl.datacenter.app.unique;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = CompanyUniqueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCompany {
    String message() default "Istnieje już firma z taką nazwą";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {

    };
}
