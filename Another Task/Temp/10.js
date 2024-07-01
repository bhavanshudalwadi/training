class StudentInformationSystem {
    constructor() {
        this.students = [];
    }

    addStudent(name, age, grade) {
        const student = { name, age, grade };
        this.students.push(student);
    }

    getStudents() {
        return this.students;
    }
}

const std = new StudentInformationSystem();

std.addStudent("John Doe", 20, "A");
std.addStudent("Jane Smith", 22, "B");

const allStudents = std.getStudents();
console.log(allStudents);
