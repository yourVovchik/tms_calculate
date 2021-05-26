package by.project.spring.calculate.dao;

import by.project.spring.calculate.model.entity.Operation.HistoryOperation;
import by.project.spring.calculate.model.entity.Operation.Operation;
import by.project.spring.calculate.model.entity.user.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface HistoryDAO {
    List<HistoryOperation> getOperations();
    List<HistoryOperation> getByUser(User user);
    void setOperation(HistoryOperation operation);


}
