package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operation.Value;
import edu.austral.ingsis.math.operation.composedOperation.*;
import edu.austral.ingsis.math.operation.singleOperation.Module;
import edu.austral.ingsis.math.operation.singleOperation.SquareRoot;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Function function = new Addition(new Value(1.0), new Value(6.0));
    final Double result = function.solve();
    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function function = new Division(new Value(12.0), new Value(2.0));
    final Double result = function.solve();
    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Function division = new Division(new Value(9.0), new Value(2.0));
    Function multiplication = new Multiplication(division, new Value(3.0));
    final Double result = multiplication.solve();
    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Function division = new Division(new Value(27.0), new Value(6.0));
    Function power = new Power(division, new Value(2.0));
    final Double result = power.solve();
    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function squareRoot = new SquareRoot(new Value(36.0));
    final Double result = squareRoot.solve();
    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Function module = new Module(new Value(136.0));
    final Double result = module.solve();
    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function module = new Module(new Value(-136.0));
    final Double result = module.solve();
    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Function sub = new Subtraction(new Value(5.0), new Value(5.0));
    Function mult = new Multiplication(sub, new Value(8.0));
    final Double result = mult.solve();
    assertThat(result, equalTo(0d));
  }
}
