package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculateAbsolute implements Function{


    private final Function function;

    public CalculateAbsolute(Function function) {
        this.function = function;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return Math.abs(map.get(function));
    }

    @Override
    public String print() {
        return "|" + function.print() + "|";
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
