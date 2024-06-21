package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.operation.Value;
import edu.austral.ingsis.math.operation.Variable;
import edu.austral.ingsis.math.operation.composedOperation.ComposedOperation;
import edu.austral.ingsis.math.operation.singleOperation.SingleOperation;

public class ListOperation implements Visitor{
    @Override
    public Object visit(ComposedOperation operation) {
        return null;
    }

    @Override
    public Object visit(SingleOperation operation) {
        return null;
    }

    @Override
    public Object visit(Variable variable) {
        return null;
    }

    @Override
    public Object visit(Value value) {
        return null;
    }
}
