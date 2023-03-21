package homeWork9

/**
 * Group class contains the list of students of concrete group
 *
 * @constructor checks if given group name is correct and initializes field groupName
 *
 * @param _groupName represents the name of group
 */
class Group(_groupName: String) {
    var groupName = ""
    var studentList = ArrayList<Student>(30)

    init {
        if (_groupName.matches("[A-Za-z]{2}-[0-2|9]{2}".toRegex())) {
            groupName = _groupName
        }
    }

    /**
     * Add student to group
     *
     * @param student
     */
    fun addStudentToGroup(student: Student) {
        if (student.lastName != null) {
            if (student.group.equals(groupName)) {
                studentList.add(student)
            } else {
                println("\n${student.firstName} ${student.lastName} is not in $groupName")
            }
        }


    }

    /**
     * Remove student from group
     *
     * @param student
     */
    fun removeStudentFromGroup(student: Student) {
        studentList.remove(student)
    }

    /**
     * Print the list of students in concreate group
     *
     */
    fun printGroup() {
        println("\nGroup $groupName:")
        studentList.forEach { student -> println("\t${student.firstName} ${student.lastName}") }
    }


}