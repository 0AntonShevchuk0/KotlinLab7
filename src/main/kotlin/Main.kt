import java.lang.Exception
import java.lang.NumberFormatException

//функція main, яка є точкою початку роботи програми.
fun main() {
    //за допомогою стандартної функції виведення print виводимо допоміжний текст,
    //щоб користувач точно зрозумів, що відбувається
    print("Enter count of fibonacci numbers: ")
    //за допомогою стандартної функції введення отримуємо від користувача дані
    var input = readln()
    //так як дані будут запитуватись багато разів, доцільно ввести змінну ззовні
    var number:Int;
    //через можливість некоректних даних, їх обробку та подальше використання
    //виносимо в блок try catch для перехоплення помилок
    try {
        //намагаємося привести рядки до типу Int за допомогою функції toInt
        number = input.toInt();
        showFibonacci(number)
    }
    //перехоплення помилки некоректого формату даних
    catch (e: NumberFormatException) {
        println("You need to enter only integer number")
    }
    //перехоплення інших помилок
    catch (e : Exception) {
        println(e.message)
    }

    print("Enter number for factorial: ")
    input = readln()
    try {
        number = input.toInt();
        //за допомогою форматування рядків, виводимо красиво результат на екран
        println("Factorial = ${getFactorial(number)}")
    }
    catch (e: NumberFormatException) {
        println("You need to enter only integer number")
    }
    catch (e : Exception) {
        println(e.message)
    }

    print("Enter natural number to get number of digits: ")
    input = readln()
    try {
        number = input.toInt();
        println("Number of digits = ${getDigits(number)}")
    }
    catch (e: NumberFormatException) {
        println("You need to enter only integer number")
    }
    catch (e : Exception) {
        println(e.message)
    }
}

//функція для показу заданої кількості чисел Фібоначчі на кончлоь
fun showFibonacci(count: Int) {
    //числа фібоначчі є тільки для цілих додатних чисел
    if (count < 0) {
        //створюємо помилку, щоб не рахувати некоректні дані
        throw Exception("Cant calculate fibonacci for negative number");
    }
    println("Fibonacci:")
    //для 0 виводимо завжди
    println("0 - 0")
    //1 - один із перших важливих членів, тому виводимо окремо
    if (count >= 1)
        println("1 - 1")
    //виводимо всі інші
    if (count > 1) {
        var number1 = 0
        var number2 = 1
        var currentNumber:Int
        for (i in 2..count) {
            //число Фібоначчі - сума 2 попередніх чисел у цьому ряді, за виключенням перших 2
            currentNumber = number1 + number2
            println("$i - $currentNumber")
            //попередні числа змінюються
            number1 = number2
            number2 = currentNumber
        }
    }
}

//функція для знаходження факторіалу за допомогою рекурсії
fun getFactorial(number: Int) : Int {
    //немає факторіалу для від'ємних чисел, тому створюємо помилку
    if (number < 0) {
        throw Exception("Cant calculate factorial for negative number");
    }
    //факторіал 0 або 1 = 1
    if (number == 0 || number == 1)
        return 1
    //застосовуючи рекурсивний виклик, рахуємо значення
    return number * getFactorial(number - 1)
}

//функція для знаходження числа знаків натурального числа
fun getDigits(number: Int): Int {
    //перевірка чи є число натуральним
    if (number <= 0) {
        throw Exception("This function calculate only natural numbers digits");
    }
    //число має мати хоча б 1 цифру
    var digitsNumber = 1;
    //робимо копію аргументу, яку можна змінювати
    var tmpNumber = number;
    //визначаємо кількість цифр за допомогою ділення на 10
    while (tmpNumber / 10 != 0) {
        tmpNumber /= 10;
        digitsNumber++;
    }
    return digitsNumber;
}
