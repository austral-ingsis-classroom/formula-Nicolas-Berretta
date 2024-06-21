package edu.austral.ingsis.math.operation.composedOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.operation.Operand;
import edu.austral.ingsis.math.visitor.Visitor;

public class Division implements ComposedOperation {

  private final Function dividendNode;
  private final Function divisorNode;

  public Division(Function dividendNode, Function divisorNode) {
    this.dividendNode = dividendNode;
    this.divisorNode = divisorNode;
  }

  @Override
  public Operand getOperand() {
    return Operand.DIVISION;
  }

  @Override
  public Function getLeftNode() {
    return dividendNode;
    // in this case, the dividend node would be the left node (?)
  }

  @Override
  public Function getRightNode() {
    return divisorNode;
  }

  @Override
  public Double solve() {
    return dividendNode.solve() / divisorNode.solve();
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}

//          "/"
//        /     \
//  dividend    divisor

// dividend/divisor
