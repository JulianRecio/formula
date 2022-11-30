package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.classes.*;
import edu.austral.ingsis.math.visitor.classes.CalculateAbsolute;
import edu.austral.ingsis.math.visitor.classes.visitors.ListVariablesVisitor;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {

    private final Visitor<List<String>> visitor = new ListVariablesVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final List<String> result = visitor.visit(new Addition(new Value(1), new Value(6)));

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final List<String> result = visitor.visit(new Division(new Value(12),new Variable("div")));

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final List<String> result = visitor.visit(new Multiplication(new Division(new Value(9), new Variable("x")),new Variable("y")));

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final List<String> result = visitor.visit(new Power(new Division(new Value(27),new Variable("a")), new Variable("b")));

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final List<String> result = visitor.visit(new Power(new Variable("z"), new Division(new Value(1), new Value(2))));

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final List<String> result = visitor.visit(new Subtraction(new CalculateAbsolute(new Variable("value")), new Value(8)));

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final List<String> result = visitor.visit(new Subtraction(new CalculateAbsolute(new Variable("value")), new Value(8)));

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final List<String> result = visitor.visit(new Multiplication(new Subtraction(new Value(5), new Variable("i")), new Value(8)));

        assertThat(result, containsInAnyOrder("i"));
    }
}
