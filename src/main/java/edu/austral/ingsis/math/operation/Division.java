package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;

public class Division implements Operation{

    private final Function dividendNode;
    private final Function divisorNode;

    public Division(Function dividendNode, Function divisorNode) {
        this.dividendNode = dividendNode;
        this.divisorNode = divisorNode;
    }

    @Override
    public Double solveOperation() {
        return dividendNode.solve() / divisorNode.solve();
    }
}
