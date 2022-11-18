package edu.austral.ingsis.math.composite.classes;

import edu.austral.ingsis.math.composite.interfaces.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Variable implements Function {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return map.get(name);
    }

    @Override
    public String print() {
        return name;
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List <String> copyList = new ArrayList<>();
        copyList.add(name);
        return copyList;
    }

    @Override
    public List<String> listVariables(List<String> variablesList) {
        List <String> namesList = new ArrayList<>();
        namesList.add(name);
        return Stream.concat(variablesList.stream(),namesList.stream()).collect(Collectors.toList());
    }

}
