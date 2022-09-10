package ru.sabeshkin.adt.stack.bounded;

import static org.junit.Assume.assumeNoException;

import java.util.LinkedList;
import java.util.List;

class BoundedStack<T> extends BoundedStackAbstract<T>{

	// скрытые поля
	private List<T> stack; // основное хранилище стека
	private int peek_status; // статус запроса peek()
	private int pop_status; // статус команды pop()

	// интерфейс класса, реализующий АТД BoundedStack
	public final int POP_NIL = 0;
	public final int POP_OK = 1;
	public final int POP_ERR = 2;
	public final int PEEK_NIL = 0;
	public final int PEEK_OK = 1;
	public final int PEEK_ERR = 2;
	private final int MAX_SIZE;
	private final static int DEFAULT_SIZE = 32;

	public BoundedStack() throws Exception {
		this(DEFAULT_SIZE);
	}// постусловие: создан новый пустой стек на 32 элемента
	
	// конструктор
    // предусловие: число положительно
	public BoundedStack(int maxSize) throws Exception {
		if(maxSize<1) {
			throw new Exception("Размер стека должен быть положительным числом больше 0");
		}
		MAX_SIZE = maxSize;
		clear();
	}
	// постусловие: создан новый пустой стек, на заданное кол-во элементов
	
	@Override
	public void push(T value) {
		if (size() == MAX_SIZE) {
			stack.remove(0);
		}
		stack.add(value);
	}
	@Override
	public void pop() {
		int lastIndex = getLastIndex();
		if (size() > 0) {
			stack.remove(lastIndex);
			pop_status = POP_OK;
		} else {
			pop_status = POP_ERR;
		}
	}
	
	private int getLastIndex() {
		return  size() - 1;
	}
	@Override
	public void clear() {
		stack = new LinkedList<>(); // пустой список/стек
		// начальные статусы для предусловий peek() и pop()
		peek_status = PEEK_NIL;
		pop_status = POP_NIL;
	}
	@Override
	public T peek() {
		T result;
		if (size() > 0) {
			int lastIndex = getLastIndex();
			result = stack.get(lastIndex);
			peek_status = PEEK_OK;
		} else {
			result = null;
			peek_status = PEEK_ERR;
		}
		return result;
	}

	public int size() {
		return stack.size();
	}
	@Override
	// запросы статусов
	public int get_pop_status() {
		return pop_status;
	}
	@Override
	public int get_peek_status() {
		return peek_status;
	}



	@Override
	public int get_max_size() {
		// TODO Auto-generated method stub
		return 0;
	}
}