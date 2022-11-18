package edu.austral.ingsis.math.visitor.classes;

import edu.austral.ingsis.math.visitor.interfaces.VisitableFunction;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class Value implements VisitableFunction {

    private final double value;

    public Value(double value) {
        this.value = value;
    }

    @Override
    public <T> T acceptVisit(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public double getValue() {
        return value;
    }
}
