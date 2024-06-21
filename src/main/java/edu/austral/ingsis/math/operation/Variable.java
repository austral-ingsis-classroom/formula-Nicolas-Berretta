package edu.austral.ingsis.math.operation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Variable implements Function{
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
    //this would be used like getValue, ta dudoso (?)
    public Double solve() {
        return value.solve();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitVariable(this);
    }
}
