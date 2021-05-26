package by.project.spring.calculate.dao.InMemory;

import by.project.spring.calculate.dao.HistoryDAO;
import by.project.spring.calculate.model.entity.Operation.HistoryOperation;
import by.project.spring.calculate.model.entity.Operation.Operation;
import by.project.spring.calculate.model.entity.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryHistoryDAO implements HistoryDAO {
    private static List<HistoryOperation> operations = new ArrayList<>();
    private static HistoryDAO historyDAO;

    private InMemoryHistoryDAO(){}

    public static HistoryDAO getInstance(){
        if(historyDAO == null){
            historyDAO = new InMemoryHistoryDAO();
        }
        return historyDAO;
    }

    @Override
    public List<HistoryOperation> getOperations() {
        return operations;
    }

    @Override
    public List<HistoryOperation> getByUser(User user) {
        List<HistoryOperation> historyOperations = new ArrayList<>();
        for(HistoryOperation operation : operations){
            if(operation.getUser().equals(user)){
                historyOperations.add(operation);
            }
        }
        return historyOperations;
    }

    @Override
    public void setOperation(HistoryOperation operation) {
        operations.add(operation);
    }
}
