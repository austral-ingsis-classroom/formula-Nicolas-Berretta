package edu.austral.ingsis.math.operation.composedOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.operation.Operand;
import edu.austral.ingsis.math.visitor.Visitor;

public class Multiplication implements ComposedOperation {
  private final Function leftNode;
  private final Function rightNode;

  public Multiplication(Function leftNode, Function rightNode) {
    this.leftNode = leftNode;
    this.rightNode = rightNode;
  }

  @Override
  public Operand getOperand() {
    return Operand.MULTIPLICATION;
  }

  @Override
  public Function getLeftNode() {
    return leftNode;
  }

  @Override
  public Function getRightNode() {
    return rightNode;
  }

  @Override
  public Double solve() {
    return leftNode.solve() * rightNode.solve();
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
