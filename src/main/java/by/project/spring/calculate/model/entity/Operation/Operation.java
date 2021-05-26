package by.project.spring.calculate.model.entity.Operation;

import org.springframework.stereotype.Component;

@Component
public interface Operation {
    double result(double a, double b);
}
