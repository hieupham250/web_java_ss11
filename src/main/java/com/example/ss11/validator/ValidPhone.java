package com.example.ss11.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhone {
    String message() default "Số điện thoại không hợp lệ (phải bắt đầu bằng 0 và có 10 chữ số)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
