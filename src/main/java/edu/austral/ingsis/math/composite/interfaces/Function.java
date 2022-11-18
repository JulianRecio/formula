package edu.austral.ingsis.math.composite.interfaces;

import java.util.List;
import java.util.Map;

public interface Function {
    double evaluate(Map<String, Double> map);
    String print();
    List<String> getChildren(List<String> list);
    List<String> listVariables(List<String> list);
}
