package pl.datacenter.app.unique;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = AreaUniqueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueArea {
    String message() default "Istnieje już miejsce z taką nazwą";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {

    };
}

