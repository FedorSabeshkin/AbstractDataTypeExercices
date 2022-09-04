package ru.sabeshkin.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoundedBoundedStackTest {
	
	@Test
	public void test_createStack_isErr() throws Exception {
		assertThrows(Exception.class, () -> new BoundedStack<Integer>(0)) ;
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_cyclePop_sizeIsZero() throws Exception {
		BoundedStack<Integer> stack = new BoundedStack<Integer>();
		for (int i = 0; i < 6; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			stack.pop();
		}
		for (int i = 6; i < 10; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 7; i++){
			stack.pop();
		}
		assertEquals(
				0,
				stack.size());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_seventhIsZero() throws Exception {
		BoundedStack<Integer> stack = new BoundedStack<Integer>();
		for (int i = 0; i < 6; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			stack.pop();
		}
		for (int i = 6; i < 10; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 6; i++){
			stack.pop();
		}
		assertEquals(
				new Integer(0),
				stack.peek());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_eightPopIsNull() throws Exception {
		BoundedStack<Integer> stack = new BoundedStack<Integer>();
		for (int i = 0; i < 6; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			stack.pop();
		}
		for (int i = 6; i < 10; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 7; i++){
			stack.pop();
		}
		stack.pop();
		assertEquals(
				null,
				stack.peek());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_sizeIsEight() throws Exception {
		BoundedStack<Integer> stack = new BoundedStack<Integer>();
		for (int i = 0; i < 6; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			stack.pop();
		}
		for (int i = 6; i < 10; i++){
			stack.push(new Integer(i));
		}
		assertEquals(
				7,
				stack.size());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_peekIsEight() throws Exception {
		BoundedStack<Integer> stack = new BoundedStack<Integer>();
		for (int i = 0; i < 6; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			stack.pop();
		}
		for (int i = 6; i < 10; i++){
			stack.push(new Integer(i));
		}
		assertEquals(
				new Integer(9),
				stack.peek());
	}

	@Test
	public void test_integer_secondIsEight() throws Exception {
		BoundedStack<Integer> stack = new BoundedStack<Integer>();
		for (int i = 0; i < 10; i++){
			stack.push(new Integer(i));
		}
		stack.pop();
		assertEquals(
				new Integer(8),
				stack.peek());
	}


	@Test
	public void test_integer_peekIsNine() throws Exception {
		BoundedStack<Integer> stack = new BoundedStack<Integer>();
		for (int i = 0; i < 10; i++){
			stack.push(new Integer(i));
		}
		assertEquals(
				new Integer(9),
				stack.peek());
	}

	@Test
	public void test_emptyBoundedStack_sizeIsZero() throws Exception {
		BoundedStack<String> stack = new BoundedStack<>();
		assertEquals(
				0,
				stack.size());
	}

	@Test
	public void test_emptyBoundedStack_secondPopEqualNull() throws Exception {
		BoundedStack<Object> stack = new BoundedStack<>();
		stack.pop();
		stack.pop();
		assertEquals(
				null,
				stack.peek());
	}

	@Test
	public void test_emptyBoundedStack_popEqualNull() throws Exception {
		BoundedStack<?> stack = new BoundedStack<Object>();
		stack.pop();
		assertEquals(
				null,
				stack.peek());
	}

	@Test
	public void test_emptyBoundedStack_peekEqualNull() throws Exception {
		BoundedStack<?> stack = new BoundedStack<Object>();
		assertEquals(
				null,
				stack.peek());
	}

	@Test
	public void test_integer_onlyOneElement() throws Exception {
		BoundedStack<Integer> stack = new BoundedStack<Integer>();
		stack.push(new Integer(0));
		assertEquals(
				new Integer(0),
				stack.peek());
	}

	@Test
	public void test_string() throws Exception {
		BoundedStack<Comparable> stack = new BoundedStack<Comparable>();
		stack.push(new Integer(0));
		stack.push(new String("test"));
		assertEquals(
				new String("test"),
				stack.peek());
	}


}
