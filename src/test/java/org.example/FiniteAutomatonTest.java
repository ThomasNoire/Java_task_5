package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FiniteAutomatonTest {

    @ParameterizedTest
    @CsvSource({
            "'abcTESTabc', F",
            "'abcTES', THREE",
            "'TTEST', F",
            "'abcTEST', F",
            "'abcTESabc', S",
            "'TESabc', S"
    })
    public void testFiniteAutomaton(String input, String expected) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        String result = String.valueOf(automaton.run(input));
        assertEquals(expected, result);
    }


    @ParameterizedTest
    @CsvSource({
            "'abcTESTabc', true",
            "'abcTES', false",
            "'TTEST', true",
            "'abcTEST', true",
            "'abcTESabc', false",
            "'TESabc', false"
    })
    public void testIsFinalState(String input, boolean expectedFinalState) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        automaton.run(input);
        assertEquals(expectedFinalState, automaton.isFinalState());
    }
}
