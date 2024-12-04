package org.example;

public class FiniteAutomaton {


    enum State {
        S, ONE, TWO, THREE, F
    }

    private State currentState;


    public FiniteAutomaton() {
        this.currentState = State.S;
    }

    // Метод для обработки одного символа
    private void processSymbol(char symbol) {
        switch (currentState) {
            case S:
                if (symbol == 'T') currentState = State.ONE;
                break;
            case ONE:
                if (symbol == 'E') currentState = State.TWO;
                else if (symbol == 'T') currentState = State.ONE;
                else currentState = State.S;
                break;
            case TWO:
                if (symbol == 'S') currentState = State.THREE;
                else if (symbol == 'T') currentState = State.ONE;
                else currentState = State.S;
                break;
            case THREE:
                if (symbol == 'T') currentState = State.F;
                else currentState = State.S;
                break;
            case F:

                break;
        }
    }


    public State run(String input) {
        for (char symbol : input.toCharArray()) {
            processSymbol(symbol);
        }
        return currentState;
    }

    public boolean isFinalState() {
        return currentState == State.F;

    }


}

