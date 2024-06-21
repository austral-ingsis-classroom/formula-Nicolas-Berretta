package edu.austral.ingsis.math.operation.composedOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.operation.Operand;

public class Power implements ComposedOperation {
    private final Function baseNode;
    private final Function exponentNode;

    public Power(Function baseNode, Function exponentNode) {
        this.baseNode = baseNode;
        this.exponentNode = exponentNode;
    }

    @Override
    public Operand getOperand() {
        return Operand.POWER;
    }

    @Override
    public Function getLeftNode() {
        return baseNode;
    }

    @Override
    public Function getRightNode() {
        return exponentNode;
    }

    @Override
    public Double solve() {
        return Math.pow(baseNode.solve(), exponentNode.solve()) ;
    }
    //        "^"
    //     /       \
    //  base     exponent
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
