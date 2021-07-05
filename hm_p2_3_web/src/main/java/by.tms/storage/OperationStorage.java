package by.tms.storage;

import by.tms.entity.Operation;
import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OperationStorage {

    private static List<Operation> listOfOperations = new ArrayList<>();

    public void save(Operation o){
        listOfOperations.add(o);
    }

    public List<Operation> getAll(){
        return new ArrayList<>(listOfOperations);
    }

    public List<Operation> getAllByUsername(User user){
        List<Operation> operationListByUser = new ArrayList<>();

        for (Operation op: listOfOperations){
            if (op.getUser().getUsername().equals(user.getUsername())){
                operationListByUser.add(op);
            }
        }
        return operationListByUser;
    }

    public List<Operation> deleteOperationByUser(User user){
        List<Operation> operationListByUser = getAllByUsername(user);
        operationListByUser.clear();
        return operationListByUser;
    }

}
