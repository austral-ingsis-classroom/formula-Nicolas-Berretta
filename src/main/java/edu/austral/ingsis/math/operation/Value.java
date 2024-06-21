package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Value implements Function {
  private final Double value;

  public Value(Double value) {
    this.value = value;
  }

  @Override
  public Double solve() {
    return value;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
