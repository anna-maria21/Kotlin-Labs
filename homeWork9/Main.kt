package homeWork9

import kotlin.math.abs

fun main() {
    println("The start of this academic year is: ${Student.startDate}\nStudents have been studying for ${Student.daysCounter()} days\n")
    val student1 = Student("Taras", "Shevchenko", "TV-01", "2001-10-30")
    println(student1)
    val dayToBirth = student1.getDaysToBirthDay()
    if (dayToBirth != null) {
        if (dayToBirth >= 0) {
            println("The birth day of student is in $dayToBirth day(s)")
        } else {
            println("The birth day of student was ${abs(dayToBirth)} day(s) ago")
        }
    }


    val student2 = Student("Vasyl", "Stus", "TV-01", "2000-10-30")
    val student3 = Student("Stepan", "Bandera", "TV-91", "2002-09-05")

    val groupTV01 = Group("TV-01")
    groupTV01.addStudentToGroup(student1)
    groupTV01.addStudentToGroup(student2)
    groupTV01.addStudentToGroup(student3)
    groupTV01.printGroup()
}

