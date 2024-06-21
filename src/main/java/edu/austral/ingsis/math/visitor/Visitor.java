package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.operation.Value;
import edu.austral.ingsis.math.operation.Variable;
import edu.austral.ingsis.math.operation.composedOperation.ComposedOperation;
import edu.austral.ingsis.math.operation.singleOperation.SingleOperation;

public interface Visitor<T> {
    T visitComposedOperation(ComposedOperation operation);
    T visitSingleOperation(SingleOperation operation);
    T visitVariable(Variable variable);
    T visitValue(Value value);
}
