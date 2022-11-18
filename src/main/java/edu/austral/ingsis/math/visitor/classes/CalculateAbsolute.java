package edu.austral.ingsis.math.visitor.classes;

import edu.austral.ingsis.math.visitor.interfaces.VisitableFunction;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class CalculateAbsolute implements VisitableFunction {

    private final VisitableFunction function;

    public CalculateAbsolute(VisitableFunction function) {
        this.function = function;
    }

    public VisitableFunction getFunction() {
        return function;
    }

    @Override
    public <T> T acceptVisit(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
