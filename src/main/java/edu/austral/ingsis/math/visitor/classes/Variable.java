package edu.austral.ingsis.math.visitor.classes;

import edu.austral.ingsis.math.visitor.interfaces.VisitableFunction;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class Variable implements VisitableFunction {

    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }

    @Override
    public <T> T acceptVisit(Visitor<T> visitor) {
        return visitor.visit(this);
    }


}
