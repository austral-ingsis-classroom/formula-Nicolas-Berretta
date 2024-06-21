package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

public interface Function {
    Double solve();
    <T> T accept(Visitor<T> visitor);
}
