package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.classes.*;
import edu.austral.ingsis.math.visitor.classes.CalculateAbsolute;
import edu.austral.ingsis.math.visitor.classes.visitors.EvaluateVisitor;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    private final Visitor<Double> visitor = new EvaluateVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Double result = visitor.visit(new Addition(new Value(1), new Value(6)));

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Double result = visitor.visit(new Division(new Value(12),new Value(2)));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Double result = visitor.visit(new Multiplication(new Division(new Value(9), new Value(2)), new Value(3)));

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Double result = visitor.visit(new Power(new Division(new Value(27), new Value(6)),new Value(2)));

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Double result = visitor.visit(new Root(new Value(36), new Value(2)));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Double result = visitor.visit(new CalculateAbsolute(new Value(136)));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Double result = visitor.visit(new CalculateAbsolute(new Value(-136)));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Double result = visitor.visit(new Multiplication(new Subtraction(new Value(5), new Value(5)), new Value(8)));

        assertThat(result, equalTo(0d));
    }
}
