package by.korzun.calculator.storage;

import java.util.List;

public interface OperationStorage {
    void save();
    List<?> findAll();
}
