package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.classes.*;
import edu.austral.ingsis.math.composite.interfaces.Function;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Function valA = new Value(1);
        final Function valB = new Value(6);
        final Function addBToA = new Addition(valA,valB);
        final Double result = addBToA.evaluate();

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Function valA = new Value(12);
        final Function valB = new Value(2);
        final Function division = new Division(valA,valB);
        final Double result = division.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Function valA = new Value(9);
        final Function valB = new Value(2);
        final Function valC = new Value(3);

        final Function division = new Division(valA, valB);
        final Function multiplication = new Multiplication(division,valC);

        final Double result = multiplication.evaluate();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Function valA = new Value(27);
        final Function valB = new Value(6);
        final Function valC = new Value(2);

        final Function division = new Division(valA, valB);
        final Function power = new Power(division,valC);
        final Double result = 20.25;

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Function valA = new Value(36);
        final Function valB = new Value(2);

        final Function root = new Root(valA,valB);
        final Double result = root.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Function val = new Value(136);

        final Function absolute = new CalculateAbsolute(val);
        final Double result = absolute.evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Function val = new Value(-136);

        final Function absolute = new CalculateAbsolute(val);
        final Double result = absolute.evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Function valA = new Value(5);
        final Function valB = new Value(5);
        final Function valC = new Value(8);

        final Function subtraction = new Substraction(valA,valB);
        final Function multiplication = new Multiplication(subtraction, valC);
        final Double result = multiplication.evaluate();

        assertThat(result, equalTo(0d));
    }
}
