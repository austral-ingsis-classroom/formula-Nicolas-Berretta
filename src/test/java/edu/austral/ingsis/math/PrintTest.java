package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operation.Value;
import edu.austral.ingsis.math.operation.Variable;
import edu.austral.ingsis.math.operation.composedOperation.*;
import edu.austral.ingsis.math.operation.singleOperation.AddParentheses;
import edu.austral.ingsis.math.operation.singleOperation.Module;
import edu.austral.ingsis.math.visitor.PrintOperation;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    PrintOperation printOperation = new PrintOperation();
    final String expected = "1 + 6";
    Function function = new Addition(new Value(1.0),new Value(6.0));
    final String result = function.accept(printOperation);
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    PrintOperation printOperation = new PrintOperation();
    final String expected = "12 / 2";
    Function function = new Division(new Value(12.0),new Value(2.0));
    final String result = function.accept(printOperation);
    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    PrintOperation printOperation = new PrintOperation();
    Function div = new AddParentheses(new Division(new Value(9d), new Value(2d)));
    Function mult = new Multiplication(div, new Value(3d));
    final String result = mult.accept(printOperation);
    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    PrintOperation printOperation = new PrintOperation();
    final String expected = "(27 / 6) ^ 2";
    Function division = new AddParentheses(new Division(new Value(27.0),new Value(6.0)));
    Function multiplication = new Power(division,new Value(2.0));
    final String result = multiplication.accept(printOperation);
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    PrintOperation printOperation = new PrintOperation();
    Function module = new Module(new Variable("value", new Value(8.0)));
    Function subtraction  = new Subtraction(module, new Value(8.0));
    final String result = subtraction.accept(printOperation);
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    PrintOperation printOperation = new PrintOperation();
    Function module = new Module(new Variable("value", new Value(- 8.0)));
    Function subtraction  = new Subtraction(module, new Value(8.0));
    final String result = subtraction.accept(printOperation);
    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    PrintOperation printOperation = new PrintOperation();
    Function subtraction  = new AddParentheses(new Subtraction(new Value(5.0), new Variable("i",new Value(2.0))));
    Function multiplication  = new Multiplication(subtraction, new Value(8.0));
    final String result = multiplication.accept(printOperation);
    assertThat(result, equalTo(expected));
  }
}
