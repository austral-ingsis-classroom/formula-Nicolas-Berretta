package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Value implements Function{
    private final Double value;

    public Value(Double value) {
        this.value = value;
    }
    //TODO solve with value, makes sense (?)
    //TODO maybe change to get only the value instead of treating it as an operation
    @Override
    public Double solve() {
        return value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitValue(this);
    }
}
