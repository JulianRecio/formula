package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.classes.*;
import org.junit.Test;

import java.util.Collections;
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
        final Double result = new Addition(new Value(1), new Variable("x")).evaluate(map);

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Double result = new Division(new Value(12), new Variable("div")).evaluate(Collections.singletonMap("div", 4.0));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final Map<String,Double> map = new HashMap<>();
        map.put("x",3.0);
        map.put("y",4.0);
        final Double result = new Multiplication(new Division(new Value(9), new Variable("x")),new Variable("y")).evaluate(map);

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final Map<String,Double> map = new HashMap<>();
        map.put("a",9.0);
        map.put("b",3.0);
        final Double result = new Power(new Division(new Value(27), new Variable("a")), new Variable("b")).evaluate(map);

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final Map<String,Double> map = new HashMap<>();
        map.put("z",36.0);
        final Double result = new Root(new Variable("z"),  new Value(2)).evaluate(map);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Map<String,Double> map = new HashMap<>();
        map.put("value",8.0);
        final Double result = new Substraction(new CalculateAbsolute(new Variable("value")), new Value(8)).evaluate(map);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final Map<String,Double> map = new HashMap<>();
        map.put("value",-8.0);
        final Double result = new Substraction(new CalculateAbsolute(new Variable("value")), new Value(8)).evaluate(map);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Map<String,Double> map = new HashMap<>();
        map.put("i",2.0);
        final Double result = new Multiplication(new Substraction(new Value(5), new Variable("i")),new Value(8)).evaluate(map);

        assertThat(result, equalTo(24d));
    }
}
