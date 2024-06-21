package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.Collections;
import java.util.List;

import edu.austral.ingsis.math.operation.Value;
import edu.austral.ingsis.math.operation.Variable;
import edu.austral.ingsis.math.operation.composedOperation.*;
import edu.austral.ingsis.math.operation.singleOperation.Module;
import edu.austral.ingsis.math.operation.singleOperation.SquareRoot;
import edu.austral.ingsis.math.visitor.ListVariable;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    ListVariable listVariable = new ListVariable();
    Function function = new Addition(new Value(1.0),new Value(6.0));
    final List<String> result = function.accept(listVariable);
    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    ListVariable listVariable = new ListVariable();
    Function function = new Division(new Value(12.0), new Variable("div",new Value(4.0)));
    final List<String> result = function.accept(listVariable);
    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    ListVariable listVariable = new ListVariable();
    Function division = new Division(new Value(9.0), new Variable("x",new Value(3.0)));
    Function multiplication = new Multiplication(division, new Variable("y",new Value(4.0)));
    final List<String> result = multiplication.accept(listVariable);
    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    ListVariable listVariable = new ListVariable();
    Function division = new Division(new Value(27.0), new Variable("a",new Value(9.0)));
    Function power = new Power(division, new Variable("b",new Value(3.0)));
    final List<String> result = power.accept(listVariable);
    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    ListVariable listVariable = new ListVariable();
    Function squareRoot = new SquareRoot(new Variable("z", new Value(36.0)));
    final List<String> result = squareRoot.accept(listVariable);
    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    ListVariable listVariable = new ListVariable();
    Function module = new Module(new Variable("value", new Value(8.0)));
    Function subtraction  = new Subtraction(module, new Value(8.0));
    final List<String> result = subtraction.accept(listVariable);
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    ListVariable listVariable = new ListVariable();
    Function module = new Module(new Variable("value", new Value(-8.0)));
    Function subtraction  = new Subtraction(module, new Value(8.0));
    final List<String> result = subtraction.accept(listVariable);
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    ListVariable listVariable = new ListVariable();
    Function subtraction  = new Subtraction(new Value(5.0), new Variable("i",new Value(2.0)));
    Function multiplication  = new Multiplication(subtraction, new Value(8.0));
    final List<String> result = multiplication.accept(listVariable);
    assertThat(result, containsInAnyOrder("i"));
  }
}
