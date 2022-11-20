/**
Наследование с конкретизацией (reification inheritance)
Абстрактный класс List
Его реализации LinkedList и ArrayList
**/

abstract class List<T>{

	protected int addStatus;
	protected int containsStatus;

	void add(T item);
	
	boolean isContains(T item);
	
	int getAddStatus(){
		return addStatus;
	}
	
	int isContainsStatus(){
		return containsStatus;
	}
}


abstract class ArrayList<T> extends List<T>{ 

	@Override	
	void add(T item){
		/**
		Реализация метода add() для ArrayList
		*/
	}
	
	@Override
	boolean isContains(T item){
		/**
		Реализация метода isContains() для ArrayList
		*/
	}
	
}