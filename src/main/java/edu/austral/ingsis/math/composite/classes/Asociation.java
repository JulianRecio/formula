package edu.austral.ingsis.math.composite.classes;

import edu.austral.ingsis.math.composite.interfaces.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Asociation implements Function {

    private final Function function;

    public Asociation(Function function) {
        this.function = function;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return map.get(function);
    }

    @Override
    public String print() {
        return "(" + function.print() + ")";
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copyList = new ArrayList<>(list);
        copyList.addAll(function.getChildren(copyList));
        return copyList;
    }

    @Override
    public List<String> listVariables(List<String> list) {
        return function.listVariables(list);
    }
}
