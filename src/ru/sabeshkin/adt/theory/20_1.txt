/**
Наследования вариаций 
Класс Счетовод содержит метод "Подсчет затрат", который работает относительно долго, т.к. использует в своей реализации Счеты. 
Класс наследник Бухгалтер, переопределяет метод "Подсчет затрат", ускоряя его работу, т.к. использует внутри себя электронный калькулятор.
**/
 class OldAccountant(){
	
	private Abacus abacus;
	
	double sumTax(Tax firstTax, Tax secondTax){
		abacus.sum(firstTax, secondTax)
	}
}


 class ModernAccountant() exdends OldAccountant{
	
	private DigitalCalculator digitalCalculator;
	
	@Override
	double sumTax(Tax firstTax, Tax secondTax){
		digitalCalculator.sum(firstTax, secondTax)
	}
}