package edu.austral.ingsis.math.operation.singleOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.operation.Operand;
import edu.austral.ingsis.math.visitor.Visitor;

public class AddParentheses implements SingleOperation {
    public final Function nodeFunction;

    public AddParentheses(Function nodeFunction) {
        this.nodeFunction = nodeFunction;
    }
    @Override
    public Operand getOpeningOperand() {
        return Operand.OPEN_PARENS;
    }

    @Override
    public Operand getClosingOperand() {
        return Operand.CLOSE_PARENS;
    }

    @Override
    public Function getNodeFunction() {
        return nodeFunction;
    }

    @Override
    public Double solve() {
        return nodeFunction.solve();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
