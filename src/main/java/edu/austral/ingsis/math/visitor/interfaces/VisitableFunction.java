package edu.austral.ingsis.math.visitor.interfaces;

public interface VisitableFunction {
    <T> T acceptVisit(Visitor<T> visitor);
}
