package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing sub: 3-2=1")
    void sub() {
        // Arrange
        Long number1 = 3L;
        Long number2 = 2L;
        Long expectedValue = 1L;

        // Act
        Long result = basicCalculator.sub(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing mul: 3*2=6")
    void mul() {
        // Arrange
        Long number1 = 3L;
        Long number2 = 2L;
        Long expectedValue = 6L;

        // Act
        Long result = basicCalculator.mul(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several subs")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,    1,   -1",
            "1,    2,   -1",
            "49,  51, -2",
            "1,  100, -99"
    })
    public void severalSubs(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sub(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several muls")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0,    1,   0",
            "1,    2,   2",
            "49,  51, 2499",
            "1,  100, 100"
    })
    public void severalMuls(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.mul(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }


}
