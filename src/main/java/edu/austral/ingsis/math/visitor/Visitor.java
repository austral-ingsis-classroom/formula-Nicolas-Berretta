package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.operation.Value;
import edu.austral.ingsis.math.operation.Variable;
import edu.austral.ingsis.math.operation.composedOperation.ComposedOperation;
import edu.austral.ingsis.math.operation.singleOperation.SingleOperation;

public interface Visitor<T> {
    T visit(ComposedOperation operation);
    T visit(SingleOperation operation);
    T visit(Variable variable);
    T visit(Value value);
}
