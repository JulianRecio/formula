package edu.austral.ingsis.math.visitor.classes;

import edu.austral.ingsis.math.visitor.interfaces.Visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class getChildrenVisitor implements Visitor<List<String>> {

    private List<String> merge(List<String> listA, List<String> listB) {
        List<String> merged = new ArrayList<>();
        merged.addAll(listA);
        merged.addAll(listB);
        return merged;
    }

    @Override
    public List<String> visit(Power power) {
        return merge(power.getFunctionA().acceptVisit(this), power.getFunctionB().acceptVisit(this));
    }

    @Override
    public List<String> visit(Root root) {
        return merge(root.getFunctionA().acceptVisit(this), root.getFunctionB().acceptVisit(this));
    }

    @Override
    public List<String> visit(Multiplication multiplication) {
        return merge(multiplication.getFunctionA().acceptVisit(this), multiplication.getFunctionB().acceptVisit(this));
    }

    @Override
    public List<String> visit(Division division) {
        return merge(division.getFunctionA().acceptVisit(this), division.getFunctionB().acceptVisit(this));
    }

    @Override
    public List<String> visit(Addition addition) {
        return merge(addition.getFunctionA().acceptVisit(this), addition.getFunctionB().acceptVisit(this));
    }

    @Override
    public List<String> visit(Subtraction subtraction) {
        return merge(subtraction.getFunctionA().acceptVisit(this), subtraction.getFunctionB().acceptVisit(this));
    }

    @Override
    public List<String> visit(Association association) {
        return association.getFunction().acceptVisit(this);
    }

    @Override
    public List<String> visit(CalculateAbsolute calculateAbsolute) {
        return calculateAbsolute.getFunction().acceptVisit(this);
    }

    @Override
    public List<String> visit(Variable variable) {
        return new ArrayList<>(Collections.singleton(variable.getVariable()));
    }

    @Override
    public List<String> visit(Value value) {
        return new ArrayList<>(Collections.singleton(Double.toString(value.getValue())));
    }


}
