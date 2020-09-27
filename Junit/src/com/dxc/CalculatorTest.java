package com.dxc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		assertEquals(9, calc.add(6, 3));
		assertNotEquals(20, calc.add(6, 3));
	}

	@Test
	public void testSub() {
		Calculator calc = new Calculator();
		assertEquals(1, calc.sub(8, 7));
		assertNotEquals(11, calc.sub(8, 7));
	}

	@Test
	public void testMul() {
		Calculator calc = new Calculator();
		assertEquals(42, calc.mul(6, 7));
		assertNotEquals(11, calc.mul(6, 7));
	}

	@Test
	public void testDiv() {
		Calculator calc = new Calculator();
		assertEquals(0.01, calc.div(5, 6),0.01);
		assertNotEquals(2.5, calc.div(5, 6),0.01);
	}

}
