package edu.austral.ingsis.math.operation.singleOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.operation.Operand;

public class SquareRoot implements SingleOperation {
    private final Function leafNode;

    public SquareRoot(Function leafNode) {
        this.leafNode = leafNode;
    }
    @Override
    public Double solve() {
        return Math.sqrt(leafNode.solve());
    }
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitSingleOperation(this);
    }

    @Override
    public Operand getOpeningOperand() {
        return Operand.SQRT_OPEN;
    }

    @Override
    public Operand getClosingOperand() {
        return Operand.SQRT_CLOSE;
    }
}
