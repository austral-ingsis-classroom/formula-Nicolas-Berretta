package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;

public class Module implements Operation{
    public final Function leafNode;

    public Module(Function leafNode){
        this.leafNode = leafNode;
    }

    @Override
    public Double solveOperation() {
        return Math.abs(leafNode.solve());
    }
}
