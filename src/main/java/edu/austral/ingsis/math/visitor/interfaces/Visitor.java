package edu.austral.ingsis.math.visitor.interfaces;

import edu.austral.ingsis.math.visitor.classes.*;

public interface Visitor<T> {
    T visit(Power power);
    T visit(Root root);
    T visit(Multiplication multiplication);
    T visit(Division division);
    T visit(Addition addition);
    T visit(Subtraction subtraction);
    T visit(Association association);
    T visit(CalculateAbsolute calculateAbsolute);
    T visit(Variable variable);
    T visit(Value value);
}
