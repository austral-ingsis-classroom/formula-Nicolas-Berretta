package edu.austral.ingsis.math.operation.singleOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.operation.Operand;

public interface SingleOperation extends Function {
  Operand getOpeningOperand();

  Operand getClosingOperand();

  Function getNodeFunction();
}
