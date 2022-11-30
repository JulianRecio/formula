package edu.austral.ingsis.math.visitor.classes.visitors;

import edu.austral.ingsis.math.visitor.classes.*;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

import java.util.Map;

public class EvaluateVisitor implements Visitor<Double> {

    private final Map<String, Double> valuesMap;

    public EvaluateVisitor(Map<String, Double> valuesMap) {
        this.valuesMap = valuesMap;
    }

    public EvaluateVisitor() {
        this(Map.of());
    }

    @Override
    public Double visit(Power power) {
        return Math.pow(power.getFunctionA().acceptVisit(this), power.getFunctionB().acceptVisit(this));
    }

    @Override
    public Double visit(Root root) {
        return Math.pow(root.getFunctionA().acceptVisit(this), 1/root.getFunctionB().acceptVisit(this));
    }

    @Override
    public Double visit(Multiplication multiplication) {
        return multiplication.getFunctionA().acceptVisit(this) * multiplication.getFunctionB().acceptVisit(this);
    }

    @Override
    public Double visit(Division division) {
        return division.getFunctionA().acceptVisit(this) / division.getFunctionB().acceptVisit(this);
    }

    @Override
    public Double visit(Addition addition) {
        return addition.getFunctionA().acceptVisit(this) + addition.getFunctionB().acceptVisit(this);
    }

    @Override
    public Double visit(Subtraction subtraction) {
        return subtraction.getFunctionA().acceptVisit(this) - subtraction.getFunctionB().acceptVisit(this);
    }

    @Override
    public Double visit(Association association) {
        return association.getFunction().acceptVisit(this);
    }

    @Override
    public Double visit(CalculateAbsolute calculateAbsolute) {
        return Math.abs(calculateAbsolute.getFunction().acceptVisit(this));
    }

    @Override
    public Double visit(Variable variable) {
        if (valuesMap.containsKey(variable.getVariable())){
            return valuesMap.get(variable.getVariable());
        }else{
            return (double) 0;
        }
    }

    @Override
    public Double visit(Value value) {
        return value.getValue();
    }
}
