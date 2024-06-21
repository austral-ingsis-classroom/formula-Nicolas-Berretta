package edu.austral.ingsis.math.operation.composedOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.operation.Operand;

public class Addition implements ComposedOperation {

    private final Function leftNode;
    private final Function rightNode;

    public Addition(Function leftNode, Function rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public Operand getOperand() {
        return Operand.ADDITION;
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
        return leftNode.solve() + rightNode.solve();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
