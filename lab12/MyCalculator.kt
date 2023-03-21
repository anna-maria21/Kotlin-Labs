package lab12

/**
 * A class that provides some operations with entered numbers
 * @property a is a first number entered by user
 * @property b is a second number entered by user
 * @property operation is an operation entered by user
 */
class MyCalculator(var a: Double, var b: Double, var operation: Char) {
    var result:Double = 0.0

    /**
     * Fill the object field result after its creation
     * by doing mathematical operation with numbers entered by user
     */
    init {
        when (operation) {
            '+' -> result = a + b
            '-' -> result = a - b
            '*' -> result = a * b
            '/' -> result = a / b
        }
    }

    /**
     * Override method for printing information about current object
     * @return Result String witch represents math statement
     */
    override fun toString(): String {
        return "$a $operation $b = $result"
    }



}