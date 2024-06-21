package edu.austral.ingsis.math.operation;

public enum Operand {
    ADDITION(" + "),
    DIVISION(" / "),
    MULTIPLICATION(" * "),
    POWER(" ^ "),
    SUBTRACTION(" - "),
    //Single operations
    SQRT_OPEN("sqrt("),
    SQRT_CLOSE(")"),
    MODULE("|"),
    OPEN_PARENS("("),
    CLOSE_PARENS(")");

    private final String operandSymbol;
    Operand(String operandSymbol) {
        this.operandSymbol = operandSymbol;
    }
    public String getOperandSymbol() {
        return operandSymbol;
    }
}
