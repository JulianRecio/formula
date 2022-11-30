package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.classes.*;
import edu.austral.ingsis.math.visitor.classes.CalculateAbsolute;
import edu.austral.ingsis.math.visitor.classes.visitors.PrintVisitor;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    private final Visitor<String> visitor = new PrintVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final String result = visitor.visit(new Addition(new Value(1), new Value(6)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        final String result = visitor.visit(new Division(new Value(12),new Value(2)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        final String result = visitor.visit(new Multiplication(new Association(new Division(new Value(9), new Value(2))), new Value(3)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        final String result = visitor.visit(new Power(new Association(new Division(new Value(27), new Value(6))),new Value(2)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final String result = visitor.visit(new Subtraction(new CalculateAbsolute(new Variable("value")), new Value(8)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        final String result = visitor.visit(new Subtraction(new CalculateAbsolute(new Variable("value")), new Value(8)));


        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        final String result = visitor.visit(new Multiplication(new Association(new Subtraction(new Value(5), new Variable("i"))), new Value(8)));

        assertThat(result, equalTo(expected));
    }
}
