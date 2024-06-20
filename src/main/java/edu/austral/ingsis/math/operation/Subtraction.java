package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;

public class Subtraction implements Operation{

    private final Function leftNode;
    private final Function rightNode;

    public Subtraction(Function leftNode, Function rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    @Override
    public Double solveOperation() {
        return leftNode.solve() - rightNode.solve();
    }
}
