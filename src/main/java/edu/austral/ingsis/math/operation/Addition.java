package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;

public class Addition implements Operation{

    private final Function leftNode;
    private final Function rightNode;

    public Addition(Function leftNode, Function rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public Double solveOperation() {
        return leftNode.solve() + rightNode.solve();
    }
}
