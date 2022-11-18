package edu.austral.ingsis.math.visitor.classes;

import edu.austral.ingsis.math.visitor.interfaces.VisitableFunction;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class Subtraction implements VisitableFunction {

    private final VisitableFunction functionA;
    private final VisitableFunction functionB;

    public Subtraction(VisitableFunction functionA, VisitableFunction functionB) {
        this.functionA = functionA;
        this.functionB = functionB;
    }

    public VisitableFunction getFunctionA() {
        return functionA;
    }

    public VisitableFunction getFunctionB() {
        return functionB;
    }

    @Override
    public <T> T acceptVisit(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
