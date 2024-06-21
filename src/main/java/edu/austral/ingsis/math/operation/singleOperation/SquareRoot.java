package edu.austral.ingsis.math.operation.singleOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.operation.Operand;

public class SquareRoot implements SingleOperation {
    private final Function nodeFunction;

    public SquareRoot(Function leafNode) {
        this.nodeFunction = leafNode;
    }
    @Override
    public Double solve() {
        return Math.sqrt(nodeFunction.solve());
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Operand getOpeningOperand() {
        return Operand.SQRT_OPEN;
    }

    @Override
    public Operand getClosingOperand() {
        return Operand.SQRT_CLOSE;
    }

    @Override
    public Function getNodeFunction() {
        return nodeFunction;
    }
}
