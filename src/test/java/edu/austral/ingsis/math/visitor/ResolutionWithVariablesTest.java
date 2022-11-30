package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.classes.*;
import edu.austral.ingsis.math.visitor.classes.CalculateAbsolute;
import edu.austral.ingsis.math.visitor.classes.visitors.EvaluateVisitor;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final Map<String,Double> map = new HashMap<>();
        map.put("x",3.0);
        final Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Addition(new Value(1), new Variable("x")));

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Map<String,Double> map = new HashMap<>();
        map.put("div",4.0);
        final Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Division(new Value(12), new Variable("div")));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final Map<String,Double> map = new HashMap<>();
        map.put("x",3.0);
        map.put("y", 4.0);
        final Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Multiplication(new Division(new Value(9), new Variable("x")),new Variable("y")));

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final Map<String,Double> map = new HashMap<>();
        map.put("a",9.0);
        map.put("b", 3.0);
        final Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Power(new Division(new Value(27),new Variable("a")), new Variable("b")));

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final Map<String,Double> map = new HashMap<>();
        map.put("z",36.0);
        final Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Power(new Variable("z"), new Division(new Value(1), new Value(2))));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Map<String,Double> map = new HashMap<>();
        map.put("value",8.0);
        final Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Subtraction(new CalculateAbsolute(new Variable("value")), new Value(8)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final Map<String,Double> map = new HashMap<>();
        map.put("value",-8.0);
        final Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Subtraction(new CalculateAbsolute(new Variable("value")), new Value(8)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Map<String,Double> map = new HashMap<>();
        map.put("i",2.0);
        final Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Multiplication(new Subtraction(new Value(5), new Variable("i")), new Value(8)));

        assertThat(result, equalTo(24d));
    }
}
