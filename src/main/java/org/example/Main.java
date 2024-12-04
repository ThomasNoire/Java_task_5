package org.example;

public class Main {
    public static void main(String[] args) {
        // Создаём экземпляр автомата
        FiniteAutomaton automaton;


        String[] testInputs = {
                "abcTESTabc",
                "abcTES",
                "TTEST",
                "abcTEST",
                "abcTESabc",
                "TESabc"
        };


        for (String input : testInputs) {
            automaton = new FiniteAutomaton();
            FiniteAutomaton.State finalState = automaton.run(input);
            boolean isFinal = automaton.isFinalState();

            // Выводим результаты для каждой строки
            System.out.println("Input: " + input);
            System.out.println("Final State: " + finalState);
            System.out.println("Contains 'TEST': " + isFinal);
            System.out.println("-----------------------------");
        }
    }
}
