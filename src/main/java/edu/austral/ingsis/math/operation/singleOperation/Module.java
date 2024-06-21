package edu.austral.ingsis.math.operation.singleOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.operation.Operand;

public class Module implements SingleOperation {
    public final Function leafNode;

    public Module(Function leafNode){
        this.leafNode = leafNode;
    }

    @Override
    public Double solve() {
        return Math.abs(leafNode.solve());
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitSingleOperation(this);
    }

    @Override
    public Operand getOpeningOperand() {
        return Operand.MODULE;
    }

    @Override
    public Operand getClosingOperand() {
        return Operand.MODULE;
    }

//    @Override
//    public Double solveOperation() {
//
//    }
//
//    @Override
//    public Operand getOperand() {
//    @Override
//    public Double solve() {
//        return 0.0;
//    }
}
