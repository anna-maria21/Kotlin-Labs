package homeWork9

import java.time.LocalDate

/**
 * A class that represented a student of KPI
 *
 * @property firstName is a name of concrete student, has type String
 * @property lastName is a surname of concrete student, has type String
 * @property group is a String representation of the student's group
 * @property age is an age of concrete student, has type Int
 * @property birthDate is a date of birth of concrete student
 * @property info is a static const value that describes any student
 * @property startDate is a start of study date in this year
 *
 */
class Student {
    var firstName: String? = null
    var lastName: String? = null
    var group: String? = null
    var age: Int = 0
    var birthDate: LocalDate? = null

    companion object {
        /**
         * Represents a static const value that describes any student
         */
        const val info = "This is student of KPI"

        /**
         * Represents a start of study date in this year
         */
        val startDate: LocalDate = LocalDate.parse("2022-09-05")

        /**
         * Calculates amount of days since start of the academic year
         *
         * @return the number of days that have passed since the beginning of the academic year
         */
        fun daysCounter(): Int {
            return LocalDate.now().dayOfYear - startDate.dayOfYear
        }
    }

    /**
     * Creates an empty instance
     */
    constructor() {}

    /**
     * Creates an instance with given info as parameters
     */
    constructor(_firstname: String, _lastName: String, _group: String, _birthDate: String) {
        var _age = LocalDate.now().year - LocalDate.parse(_birthDate).year
        if (LocalDate.now().dayOfYear < LocalDate.parse(_birthDate).dayOfYear) _age--
        if (fieldsValidation(_group, _age)) {
            firstName = _firstname
            lastName = _lastName
            group = _group
            birthDate = LocalDate.parse(_birthDate)
            age = _age
        } else {
            println("Group or age is invalid!")
        }
    }

    /**
     * Override method for printing information about concrete student
     * @return Result String with all information about student
     */
    override fun toString(): String {
        return "$info:\n\tfirstName is $firstName\n\tlastName is $lastName\n\t" +
                "group is $group\n\tage is $age years old"
    }

    /**
     * Private method for validation some arguments in constructor
     *
     * @param _group is a String representation of student's group
     * @param _age is an Int value of student's age
     * @return True if received parameters are valid, else False
     */
    private fun fieldsValidation(_group: String, _age: Int): Boolean {
        return _group.matches("[A-Za-z]{2}-[0-2|9]{2}".toRegex()) && _age > 15 && _age < 65
    }

    /**
     * Public method for calculating days to birth day
     * @return Int value of difference between day of birth and today
     */
    fun getDaysToBirthDay(): Int? {
        return if(lastName != null)
            (birthDate?.dayOfYear ?: 0) - LocalDate.now().dayOfYear
        else null
    }


}
