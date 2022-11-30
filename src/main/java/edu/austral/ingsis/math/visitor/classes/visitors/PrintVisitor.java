package edu.austral.ingsis.math.visitor.classes.visitors;

import edu.austral.ingsis.math.visitor.classes.*;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class PrintVisitor implements Visitor<String> {

    @Override
    public String visit(Power power) {
        return power.getFunctionA().acceptVisit(this) + " ^ " + power.getFunctionB().acceptVisit(this);
    }

    @Override
    public String visit(Root root) {
        return root.getFunctionA().acceptVisit(this) +"^(1/" + root.getFunctionB().acceptVisit(this) + ")";
    }

    @Override
    public String visit(Multiplication multiplication) {
        return multiplication.getFunctionA().acceptVisit(this) + " * " +  multiplication.getFunctionB().acceptVisit(this);
    }

    @Override
    public String visit(Division division) {
        return division.getFunctionA().acceptVisit(this) + " / " + division.getFunctionB().acceptVisit(this);
    }

    @Override
    public String visit(Addition addition) {
        return addition.getFunctionA().acceptVisit(this) + " + " + addition.getFunctionB().acceptVisit(this);
    }

    @Override
    public String visit(Subtraction subtraction) {
        return subtraction.getFunctionA().acceptVisit(this) + " - " + subtraction.getFunctionB().acceptVisit(this);
    }

    @Override
    public String visit(Association association) {
        return "(" + association.getFunction().acceptVisit(this) + ")";
    }

    @Override
    public String visit(CalculateAbsolute calculateAbsolute) {
        return "|" + calculateAbsolute.getFunction().acceptVisit(this) + "|";
    }

    @Override
    public String visit(Variable variable) {
        return variable.getVariable();
    }

    @Override
    public String visit(Value value) {
        return Integer.toString((int) value.getValue());
    }
}
