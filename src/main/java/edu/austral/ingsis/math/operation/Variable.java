package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;

public class Variable implements Operation{
    private final String name;
    private final Value value;

    public Variable(String name, Value value) {
        this.name = name;
        this.value = value;
    }
    public String getName() {
        return name;
    }

    //TODO maybe a variable doesn't need to be solved (?)
    @Override
    public Double solveOperation() {
        return value.solveOperation();
    }
}
