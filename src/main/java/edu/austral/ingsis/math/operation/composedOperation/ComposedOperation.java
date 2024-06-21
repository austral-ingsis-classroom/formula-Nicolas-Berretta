package edu.austral.ingsis.math.operation.composedOperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.operation.Operand;

public interface ComposedOperation extends Function {
    // no need to add solve() because classes will implement it from Function >:)
    Operand getOperand();//used for printing the operand symbol in between the Functions

    Function getLeftNode();
    Function getRightNode();
}

// node with two leaf nodes below
//Example
//              +
//            /   \
//        Value   Value

// easier to understand jijijija