package edu.austral.ingsis.math.operation.singleOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.operation.Operand;

public class Module implements SingleOperation {
    public final Function nodeFunction;

    public Module(Function nodeFunction){
        this.nodeFunction = nodeFunction;
    }

    @Override
    public Double solve() {
        return Math.abs(nodeFunction.solve());
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Operand getOpeningOperand() {
        return Operand.MODULE;
    }

    @Override
    public Operand getClosingOperand() {
        return Operand.MODULE;
    }

    @Override
    public Function getNodeFunction() {
        return nodeFunction;
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
