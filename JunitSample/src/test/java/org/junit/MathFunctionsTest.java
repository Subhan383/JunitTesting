package org.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class MathFunctionsTest {

	MathFunctions math;

	@BeforeAll
	void beforeAll() {
		System.out.println("Warm welcome before starting the Test");
	}

	@AfterAll
	void afterAll() {
		System.out.println("Your testing has completed successfully");
	}

	@BeforeEach
	void beforeEach() {
		math = new MathFunctions();
	}

	@AfterEach
	void afterEach() {
		System.out.println("Each Method Executed Successfully");
	}

	@Test
	@DisplayName("Adding Method")
	void testAdd() {
		int expected = 30;
		int actual = math.add(10, 20);
		assertEquals(expected, actual, "Adding operation Failed");
	}

	@Test
	@DisplayName("Substraction Method")
	void testSub() {
		int expected = -10;
		int actual = math.sub(10, 20);
		assertEquals(expected, actual, "Substraction Successfull");

	}

	@Test
	@DisplayName("Multiplication Method")
	@Disabled
	void testMul() {
		assertAll(() -> assertEquals(200, math.mul(10, 20)), () -> assertEquals(300, math.mul(10, 30)),
				() -> assertThrows(ArithmeticException.class, () -> math.mul(0, (10 / 0))),
				() -> assertEquals(400, math.mul(10, 40)));

	}

	@Test
	@DisplayName("Division Method")
	void testDivision() {

		int expected = 0;
		int actual = math.div(10, 20);
		assertEquals(expected, actual, "Division operation Failed");
		int denominator=0;
		assumeTrue(denominator==0);
		System.out.println("Zero value cannot be used for denomination");
		assertThrows(ArithmeticException.class, () -> math.div(10, 0), () -> "Arithmetic Exception Handled");
	}

	@Test
	@RepeatedTest(3)
	void repeating() {
		System.out.println("Subhan Sailaja");
	}
	
}
