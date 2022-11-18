package edu.austral.ingsis.math.composite.classes;

import edu.austral.ingsis.math.composite.interfaces.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Value implements Function {

    private final double value;

    public Value(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return value;
    }

    @Override
    public String print() {
        return (value % 1 != 0) ? Double.toString(value) : Integer.toString((int) value);
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copyList = new ArrayList<>(list);
        copyList.add(print());
        return copyList;
    }

    @Override
    public List<String> listVariables(List<String> list) {
        return List.of();
    }

}
