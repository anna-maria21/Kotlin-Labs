package lab12

import java.lang.NumberFormatException

fun main() {
    println("---------------------------  TASK 1  ---------------------------")
    print("Введіть символ: ")
    var userInput = readLine()
    val myChar = userInput?.let { WorkWithChar(it) }
    println("A) Is entered symbol \'${myChar!!.myChar}\' a digit: ${myChar.isDigit()}")
    println("B) Is entered symbol \'${myChar.myChar}\' a lower case latin letter: ${myChar.isLowerCaseLatinLetter()}")
    println("C) Is entered symbol \'${myChar.myChar}\' a latin letter: ${myChar.isLatinLetter()}")


    println("\n---------------------------  TASK 2  ---------------------------")
    // Нескінченний цикл для забезпечення коректності введення даних
    // поки користувач не введе коректне значення номеру дня тижня (1..7)
    // алгоритм виконання не продовжиться
    // Результат виконання алгоритму запезпечується завдяки доступу по індексу
    // в масиві усіх значень enum Weekd
    // тут же одразу реалізовано і виконання завдання №3 - пошук наступного дня тижня
    while (true) {
        try {
            print("Введіть цифру для визначення дня тижня: ")
            userInput = readLine()
            val daysValues = Weekd.values()
            val dayNumber = userInput!!.toInt() - 1
            if (dayNumber in 0..6) {
                println("День тижня за введеним числом: ${daysValues[dayNumber]}")
                println("\n---------------------------  TASK 3  ---------------------------")
                println("Наступний день тижня: ${daysValues[(dayNumber + 1) % 7]}")
                break
            } else println("Введене значення є некоректним")
        } catch (ex: NumberFormatException) {
            println("Введене значення є некоректним")
        }
    }


    println("\n---------------------------  TASK 4  ---------------------------")
    // Нескінченний цикл для забезпечення коректності введення даних
    // поки користувач не введе коректне значення змінних для конвертації їх в числа
    // алгоритм виконання не продовжиться
    // Результат виконання алгоритму запезпечується через створення об'єкту типу MyCalculator,
    // при створенні якого відбувається обрахунок результату
    try {
        print("Введіть значення а, b та операцію над ними (+-*/): ")
        userInput = readLine()
        val userInputList: List<String> = userInput!!.split("[ ,;]+".toRegex())
        val calculatorObj =
            MyCalculator(userInputList[0].toDouble(), userInputList[1].toDouble(), userInputList[2].toCharArray()[0])
        println("Результат: $calculatorObj")
    } catch (ex: NumberFormatException) {
        println("Введенi значення є некоректним")
    }

    println("\n---------------------------  TASK 5  ---------------------------")
    // При вираховуванні значень A i B для послідовних N
    // прослідковується певна закономірність для B
    val bArray: IntArray = intArrayOf(1, 3, 0, 2, 4)
    // Нескінченний цикл для забезпечення коректності введення даних
    // поки користувач не введе коректне значення змінної для конвертації її в число
    // алгоритм виконання не продовжиться
    // Результат виконання алгоритму запезпечується елементарним розв'язанням
    // рівняння з 1 змінною А, В знаходиться за доступом по індексу з масиву bArray
    while (true) {
        try {
            print("Введіть N: ")
            userInput = readLine()
            val n = userInput!!.toInt()
            if (n >= 3) {
                val b = bArray[(n - 3) % 5]
                val a = (n + 2 * b) / 5
                println("Відповідь: A=$a      B=$b \nA+B=${a + b} -> min      5*$a-2*$b=$n")
            } else println("Введене значення є некоректним")
            break
        } catch (ex: NumberFormatException) {
            println("Введене значення є некоректним")
        }
    }
}