package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operation.Value;
import edu.austral.ingsis.math.operation.Variable;
import edu.austral.ingsis.math.operation.composedOperation.*;
import edu.austral.ingsis.math.operation.singleOperation.Module;
import edu.austral.ingsis.math.operation.singleOperation.SquareRoot;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Function function = new Addition(new Value(1.0), new Variable("x", new Value(3.0)));
    final Double result = function.solve();
    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Function function = new Division(new Value(12.0), new Variable("div", new Value(4.0)));
    final Double result = function.solve();
    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Function division = new Division(new Value(9.0), new Variable("x", new Value(3.0)));
    Function multiplication = new Multiplication(division, new Variable("y", new Value(4.0)));
    final Double result = multiplication.solve();
    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Function division = new Division(new Value(27.0), new Variable("a", new Value(9.0)));
    Function power = new Power(division, new Variable("b", new Value(3.0)));
    final Double result = power.solve();
    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Function squareRoot = new SquareRoot(new Variable("z", new Value(36.0)));
    final Double result = squareRoot.solve();
    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Function module = new Module(new Variable("value", new Value(8.0)));
    Function subtraction = new Subtraction(module, new Value(8.0));
    final Double result = subtraction.solve();
    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() { // wouldn't be value = -8
    Function module = new Module(new Variable("value", new Value(-8.0)));
    Function subtraction = new Subtraction(module, new Value(8.0));
    final Double result = subtraction.solve();
    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Function subtraction = new Subtraction(new Value(5.0), new Variable("i", new Value(2.0)));
    Function multiplication = new Multiplication(subtraction, new Value(8.0));
    final Double result = multiplication.solve();
    assertThat(result, equalTo(24d));
  }
}
