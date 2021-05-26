package by.project.spring.calculate.model.entity.Operation;

import by.project.spring.calculate.model.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class HistoryOperation {
    private double a;
    private double b;
    private String operation;
    private double result;
    private User user;

    public HistoryOperation(double a, double b, String operation, double result) {
        this.a = a;
        this.b = b;
        this.operation = operation;
        this.result = result;
    }
}
