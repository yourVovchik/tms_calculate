package by.project.spring.calculate.model.entity.Operation;

import org.springframework.stereotype.Component;

@Component
public class Diff implements Operation{
    @Override
    public double result(double a, double b) {
        return a - b;
    }
}
