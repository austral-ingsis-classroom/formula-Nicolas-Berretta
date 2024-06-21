package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.operation.Value;
import edu.austral.ingsis.math.operation.Variable;
import edu.austral.ingsis.math.operation.composedOperation.ComposedOperation;
import edu.austral.ingsis.math.operation.singleOperation.SingleOperation;

public class PrintOperation implements Visitor<String>{
    @Override
    public String visit(ComposedOperation operation) {
        String leftString = operation.getLeftNode().accept(this);
        String operand = operation.getOperand().getOperandSymbol();
        String rightString = operation.getRightNode().accept(this);
        return leftString + operand + rightString;
    }

    @Override
    public String visit(SingleOperation operation) {
        String openOperation = operation.getOpeningOperand().getOperandSymbol();
        String operationString = operation.getNodeFunction().accept(this);
        String closeOperation = operation.getClosingOperand().getOperandSymbol();
        return openOperation + operationString + closeOperation;
    }

    @Override
    public String visit(Variable variable) {
        return variable.getName();
    }

    @Override
    public String visit(Value value) {
        return String.format("%.0f", value.solve());
    }
}
