package transaction_engine;

import custom_datastructures.MyStack;

public class TransactionManager {
    private VariableStore currentStore;
    private MyStack<VariableStore> transactionStack;

    public TransactionManager() {
        currentStore = new VariableStore();
        transactionStack = new MyStack<>();
    }

    public void set(String key, String value) {
        currentStore.set(key, value);
    }

    public void unset(String key) {
        currentStore.unset(key);
    }

    public String get(String key) {
        return currentStore.get(key);
    }

    public int count(String value) {
        return currentStore.count(value);
    }

    public void begin() {
        transactionStack.push(currentStore.cloneStore());
        System.out.println("Transaction started.");
    }

    public void rollback() {
        if (transactionStack.isEmpty()) {
            System.out.println("NO TRANSACTION");
            return;
        }
        currentStore = transactionStack.pop();
        System.out.println("Transaction rolled back.");
    }

    public void commit() {
        if (transactionStack.isEmpty()) {
            System.out.println("NO TRANSACTION");
            return;
        }
        transactionStack.clear();
        System.out.println("Transaction committed.");
    }

}
