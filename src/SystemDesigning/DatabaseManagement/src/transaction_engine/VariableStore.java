package transaction_engine;

import custom_datastructures.MyMap;

public class VariableStore {
    private MyMap<String, String> variables;
    private MyMap<String, Integer> valueCount;

    public VariableStore() {
        variables = new MyMap<>();
        valueCount = new MyMap<>();
    }

    public void set(String key, String value) {
        String oldValue = variables.get(key);

        if (oldValue != null) {
            decrementCount(oldValue);
        }

        variables.put(key, value);
        incrementCount(value);
    }

    public String get(String key) {
        return variables.get(key);
    }

    public void unset(String key) {
        String value = variables.get(key);
        if (value != null) {
            decrementCount(value);
            variables.remove(key);
        }
    }

    public int count(String value) {
        Integer count = valueCount.get(value);
        return count == null ? 0 : count;
    }

    public VariableStore cloneStore() {
        VariableStore cloned = new VariableStore();
        cloned.variables = this.variables.cloneMap();
        cloned.valueCount = this.valueCount.cloneMap();
        return cloned;
    }

    private void incrementCount(String value) {
        Integer count = valueCount.get(value);
        if (count == null) count = 0;
        valueCount.put(value, count + 1);
    }

    private void decrementCount(String value) {
        Integer count = valueCount.get(value);
        if (count == null || count == 0) return;
        valueCount.put(value, count - 1);
    }
}
