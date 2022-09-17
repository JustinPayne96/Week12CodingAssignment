package week12DemoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("week12DemoTest.TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b,
			int expected, boolean expectException) {
		// Given: 2 operands and an expected outcome
		
		// When: the addition method is called
		// Then: the operands are added together or an exception is thrown
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> 
		    testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);

		}
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		// Given: a random number
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		// When: a random number is drawn
		int fiveSquared = mockDemo.randomNumberSquared();
		// Then: the random number is multiplied by itself
		assertThat(fiveSquared).isEqualTo(25);
	}

	static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		return Stream.of(
				arguments(5, 6, 11, false),
				arguments(0, 12, 12, true),
				arguments(12, 0, 12, true),
				arguments(-2, 3, 1, true),
				arguments(3, -2, 1, true)
				);
		// @formatter:on
	}



}
