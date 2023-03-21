package lab7

fun main() {
    //  Створення об'єкту класу RecursionClass для наступних маніпуляцій з числами
    val recursionObject = RecursionClass()
    //  Ініціалізація полей створеного об'єкту
    recursionObject.initializeClassFields()

    //  Виведення на екран результатів виконання обрахунків

    println("1) Fibonacci numbers:")
    recursionObject.printFibonacci(recursionObject.countFibonacci())
    println("2) Factorial of entered number is: " + +recursionObject.countFactorial())
    println("3) The length of entered number is: " + recursionObject.countLongNumberLength())
}

//  Клас для роботи з числами
class RecursionClass {
    //  Поля класу, які зберігають введені користувачем дані для обрахунку
    //  чисел Фібоначчі відповідно до бажаної кількості (має тип Int для запобігання переповнення стеку і виникнення StackOverflowError),
    //  факторіалу введеного числа(має тип Int для запобігання переповнення стеку і виникнення StackOverflowError),
    //  кількості десяткових цифр, тобто "довжини" числа (має тип Long для запобігання більшої кількості можливих варіантів введення)
    //  відповідно
    private var fibonacciNumber: Int = 0
    private var factorialNumber: Int = 0
    private var longNumber: Long = 0

    //  Порожній вторинний конструктор для створення порожнього об'єкта з default значеннями полей
    constructor() {}

    //  Вторинний конструктор, який приймає значення полей для їх початкової ініціалізації
    constructor(_fibonacciNumber: Int, _factorialNumber: Int, _longNumber: Long) {
        fibonacciNumber = _fibonacciNumber
        factorialNumber = _factorialNumber
        longNumber = _longNumber
    }

    //  Метод для заповнення полей значеннями, зчитаними з клавіатури за допомогою методу inputReader()
    //  Використовується при створенні об'єкта за допомогою порожнього вторинного конструктора
    fun initializeClassFields() {
        fibonacciNumber = inputReader("Enter number of Fibonacci numbers: ").toInt()
        factorialNumber = inputReader("Enter number for factorial calculation: ").toInt()
        longNumber = inputReader("Enter some number: ")
    }

    //  Метод для читання змінних, вводимих користувачем з клавіатури
    //  Повертає введене користувачем значення змінної, тип - Long
    private fun inputReader(message: String): Long {
        var userInput: String?

        // Для забезпечення коректного введення даних у циклі do - while користувачеві пропонується
        // ввести значення конкретної змінної до тих пір, поки отримане значення не буде коректним для
        // виконання Завдання №1, тобто числовим значенням типу Double
        do {
            print(message)
            userInput = readLine()
        } while (userInput == null || !userInput.matches("\\d+".toRegex()))
        return userInput.toLong()
    }

    //  Метод, що рекурсивно обраховує числа з послідовності Фібоначі відповідно до введеної користувачем кількості
    //  На вхід приймає значення попередніх двох чисел з послідовності,
    //  а також результуючого списку значень послідовності
    //  Для першого виклику ці параметри мають значення за замовчуванням
    //  Повертає список ArrayList<Int> зі значеннями чисел послідовності Фібоначі,
    //  розмір якого відповідає значенню, введеному користувачем
    fun countFibonacci(n1: Int = 0, n2: Int = 1, resultList: ArrayList<Int> = arrayListOf(0, 1)): ArrayList<Int> {
        //  Умовою виходу з рекурсії є рівність розміру результуючого списку заданому значенню,
        //  що зберігається в полі fibonacciNumber класу
        //  Якщо ж кількість значень ще недостатня, то обчислюється значення поточного елементу послідовності,
        //  додається в список результатів і рекурсивно викликається той самий метод, якому вже передаються
        //  нові значення двох попередніх елементів і результуючий список
        if (resultList.size < fibonacciNumber) {
            val n3 = n1 + n2
            resultList.add(n3)
            return countFibonacci(n2, n3, resultList)
        }
        return resultList
    }

    //  Метод, що рекурсивно обраховує факторіал введеного користувачем числа,
    //  що зберігається в полі factorialNumber класу
    //  На вхід приймає значення поточного множника
    //  Для першого виклику цей параметр має значення за замовчуванням, що = factorialNumber
    //  Повертає число типу Long
    fun countFactorial(n: Long = factorialNumber.toLong()): Long {
        //  Умовою виходу з рекурсії є значення поточного множника <= 1
        //  При n == 0 повертається 1 згідно правила математики 0! = 1
        if (n == 0L) return 1
        //  При n <= 1 повертається число n (тобто 1, бо інші випадки або уже розглянуті, або неможливі)
        if (n <= 1) return n
        return n * countFactorial(n - 1)
    }

    //  Метод, що рекурсивно визначає кількість десяткових цифр введеного користувачем числа,
    //  що зберігається в полі longNumber класу
    //  На вхід приймає значення кількості вже оброблених розрядів числа
    //  Для першого виклику цей параметр має значення за замовчуванням, що = 0
    //  Повертає число типу Int
    fun countLongNumberLength(counter: Int = 0): Int {
        //  Умовою виходу з рекурсії є значення введеного користувачем числа < 1
        if (longNumber < 1) return counter
        //  Відкидання останньої цифри числа за допомогою цілочисельного ділення
        longNumber /= 10
        return countLongNumberLength(counter + 1)
    }

    //  Метод для виведення результатів обрахованої послідовності Фібоначі
    fun printFibonacci(arrayList: ArrayList<Int>) {
        for ((i, element: Int) in arrayList.withIndex()) {
            println("$i - $element")
        }
    }

}