package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;

public class Power implements Operation{
    private final Function baseNode;
    private final Function exponentNode;

    public Power(Function baseNode, Function exponentNode) {
        this.baseNode = baseNode;
        this.exponentNode = exponentNode;
    }
    @Override
    public Double solveOperation() {
        return Math.pow(baseNode.solve(), exponentNode.solve()) ;
    }
}
