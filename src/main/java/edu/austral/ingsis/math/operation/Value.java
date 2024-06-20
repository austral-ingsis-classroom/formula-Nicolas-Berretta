package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;

public class Value implements Operation{
    private Double value;

    public Value(Double value) {
        this.value = value;
    }
    //TODO solve operation with value, makes sense (?)
    //TODO maybe change to get only the value instead of treating it as an operation
    @Override
    public Double solveOperation() {
        return value;
    }
}
