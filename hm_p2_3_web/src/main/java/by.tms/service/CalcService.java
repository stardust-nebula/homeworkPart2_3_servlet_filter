package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.storage.OperationStorage;

import java.util.List;

public class CalcService {

    private final OperationStorage operationStorage = new OperationStorage();

    public Operation calc(double num1, double num2, String operation, User user) {

        switch (operation) {
            case "sum":
                Operation opSum = new Operation(num1, num2, operation, sum(num1, num2), user);
                operationStorage.save(opSum);
                return opSum;

            case "sub":
                Operation opSub = new Operation(num1, num2, operation, sub(num1, num2), user);
                operationStorage.save(opSub);
                return opSub;

            case "mul":
                Operation opMul = new Operation(num1, num2, operation, mul(num1, num2), user);
                operationStorage.save(opMul);
                return opMul;

            case "div":
                Operation opDiv = new Operation(num1, num2, operation, div(num1, num2), user);
                operationStorage.save(opDiv);
                return opDiv;
        }
        return null;
    }

    private double sum(double num1, double num2) {
        return num1 + num2;
    }

    private double sub(double num1, double num2) {
        return num1 - num2;
    }

    private double mul(double num1, double num2) {
        return num1 * num2;
    }

    private double div(double num1, double num2) {
        return num1 / num2;
    }

    public List<Operation> findAll() {
        return operationStorage.getAll();
    }

    public List<Operation> findAllByUsername(User user) {
        return operationStorage.getAllByUsername(user);
    }

}
