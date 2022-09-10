package ru.sabeshkin.adt.stack.bounded;

abstract class BoundedStackAbstract<T> {

	public final int POP_NIL = 0; // push() ещё не вызывалась
	public final int POP_OK = 1; // последняя pop() отработала нормально
	public final int POP_ERR = 2; // стек пуст

	public final int PEEK_NIL = 0; // push() ещё не вызывалась
	public final int PEEK_OK = 1; // последняя peek() вернула корректное значение
	public final int PEEK_ERR = 2; // стек пуст

	// команды:
// предусловие: если размер списка равен максимальному, то удаляю замый первый элемент из списка и добавляю новое
// постусловие: в стек добавлено новое значение
	public abstract void push(T value);

// предусловие: стек не пустой; 
// постусловие: из стека удалён верхний элемент
	public abstract void pop();

// постусловие: из стека удалятся все значения
	public abstract void clear();

	// запросы:
// предусловие: стек не пустой
	public abstract T peek();

	public abstract int size();

// вместимость созданного стека
	public abstract int get_max_size();

	// дополнительные запросы:
	public abstract int get_pop_status(); // возвращает значение POP_*

	public abstract int get_peek_status(); // возвращает значение PEEK_*
}