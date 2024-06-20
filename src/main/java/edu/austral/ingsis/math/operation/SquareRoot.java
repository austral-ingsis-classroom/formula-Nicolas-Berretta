package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;

public class SquareRoot implements Operation{
    private final Function leafNode;

    public SquareRoot(Function leafNode) {
        this.leafNode = leafNode;
    }

    @Override
    public Double solveOperation() {
        return Math.sqrt(leafNode.solve());
    }
}
