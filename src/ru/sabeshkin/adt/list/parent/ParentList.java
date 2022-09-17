package ru.sabeshkin.adt.list.parent;


public abstract class ParentList<T>{

public final int REMOVE_NIL = 0; // remove() ещё не вызывалась    
public final int REMOVE_OK = 1; // последняя remove() отработала нормально
public final int REMOVE_ERR = 2; // указатель на null - пустой список

public final int PUT_RIGHT_NIL = 0; // put_right() ещё не вызывалась    
public final int PUT_RIGHT_OK = 1; // последняя put_right() отработала нормально
public final int PUT_RIGHT_ERR = 2; // указатель был на нулевом элементе

public final int PUT_LEFT_NIL = 0; // put_left() ещё не вызывалась    
public final int PUT_LEFT_OK = 1; // последняя put_left() отработала нормально
public final int PUT_LEFT_ERR = 2; // ошибка при добавлении

public final int RIGHT_NIL = 0; // right() ещё не вызывалась    
public final int RIGHT_OK = 1; // последняя right() отработала нормально
public final int RIGHT_ERR = 2; // ошибка при перемещении курсора в право(возможно были на null)

public final int GET_NIL = 0; // get() ещё не вызывалась    
public final int GET_OK = 1; // последний запрос get() отработал нормально

// команды:
// предусловие: курсор находится не на null 
// постусловие: справа от текущего узла добавлено новое значение
// постусловие: в новом значении указатель на следующий узел указывает на ранее стоящий на этом месте элемент или на null, если там ничего не было
public abstract void put_right(T value); 

// постусловие: слева от текущего узла добавлено новое значение
// постусловие: в новом значении указатель на следующий узел указывает на ранее стоящий на этом месте элемент или на null, если там ничего не было
public abstract void put_left(T value); 

// предусловие: если курсор находится на null, то справа от него есть ненулевой сосед
// постусловие: курсор указывает на правого соседа прошлого узла
public abstract void right();

// предусловие: если список пуст, то указывает на null
// предусловие: он не является правым соседом никакого другого узла
// постусловие: если в списке один элемент, то совпадает с tail
public abstract void head();

// предусловие: если список пуст, то указывает на null
// предусловие: если в списке один элемент, то совпадает с head
// постусловие: справа от него нет элементов
public abstract void tail();

// предусловие: курсов указывает не на null
// постусловие: курсор указывает на правого соседа прошлого узла, если его не существовалос, то на левого соседа
// постусловие: указатель левого соседа указывает на правого соседа удаленного узла
public abstract void remove();

// постусловие: head указывает на null
// постусловие: tail указывает на null
// постусловие: size равен 0 
public abstract void clear();

// дополнительные команды (сводимы к основным)
// постусловие: новым tail стало добавленное значение
// постусловие: если ранее tail существовал, то теперь переместившись от него в право попадем на добавленный узел
public abstract void add_tail(T t);

// постусловие: если у узла на который указывал курсов был левый сосед, то левый сосед теперб указывает на правый узел
// постусловие: новый узел указывает на соседа справа такого же, как и узел который там был до замены
public abstract void replace(T t);

// постусловие: указатель указывает на узел, значение которого равно искомому, либо на null
// постусловие: найденный узел находится правее того, на котором курсор был ранее или равен ему
public abstract void find(T t);

// постусловие: вызов метода find() от head с указанным значением будет перемещать указателб на null
public abstract void remove_all(T t);

// запросы:
public abstract int size (); 

public abstract T get();

// дополнительные запросы (сводимы к основным)
public abstract boolean is_head() ;

public abstract boolean is_tail();

public abstract boolean is_value() ;

// дополнительные запросы:
public abstract int get_put_right_status(); // возвращает значение PUT_RIGHT_*
public abstract int get_put_left_status(); // возвращает значение PUT_LEFT_*
public abstract int get_right_status(); // возвращает значение RIGHT_*
public abstract int get_get_status(); // возвращает значение GET_*
public abstract int get_remove_status(); // возвращает значение REMOVE_*
}