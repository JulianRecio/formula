package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Root implements Function{

    private final Function functionA;
    private final Function functionB;

    public Root(Function functionA, Function functionB) {
        this.functionA = functionA;
        this.functionB = functionB;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return Math.pow(functionA.evaluate(map), 1 / functionB.evaluate(map));
    }

    @Override
    public String print() {
        return functionA.print() + "^(1/" + functionB.print() + ")" ;
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copyList = new ArrayList<>(list);
        copyList.addAll(functionA.getChildren(copyList));
        copyList.addAll(functionB.getChildren(copyList));
        return copyList;
    }

    @Override
    public List<String> listVariables(List<String> list) {
        return Stream.concat(functionA.listVariables(list).stream(), functionB.listVariables(list).stream()).collect(Collectors.toList());
    }
}
