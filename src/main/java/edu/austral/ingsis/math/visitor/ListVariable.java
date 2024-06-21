package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.operation.Value;
import edu.austral.ingsis.math.operation.Variable;
import edu.austral.ingsis.math.operation.composedOperation.ComposedOperation;
import edu.austral.ingsis.math.operation.singleOperation.SingleOperation;
import java.util.ArrayList;
import java.util.List;

public class ListVariable implements Visitor<List<String>> {
  private final List<String> variables = new ArrayList<>();

  @Override
  public List<String> visit(ComposedOperation operation) {
    operation.getRightNode().accept(this);
    operation.getLeftNode().accept(this);
    return variables;
  }

  @Override
  public List<String> visit(SingleOperation operation) {
    operation.getNodeFunction().accept(this);
    return variables;
  }

  @Override
  public List<String> visit(Variable variable) {
    variables.add(variable.getName());
    return variables;
  }

  @Override
  public List<String> visit(Value value) {
    return variables;
  }
}
