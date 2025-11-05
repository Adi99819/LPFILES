// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentDB {
    struct Student {
        string name;
        uint256 rollno;
        string class;
    }

    Student[] private students;

    function addStudent(string memory name, uint256 rollno, string memory class) public {
        students.push(Student(name, rollno, class));
    }

    function getStudentById(uint256 id) public view returns (string memory, uint256, string memory) {
        require(id < students.length, "Student does not exist in database");
        return (students[id].name, students[id].rollno, students[id].class);
    }

    function getTotalNumberOfStudents() public view returns (uint256) {
        return students.length;
    }
}


// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentDB {
    struct Student {
        string name;
        uint256 rollno;
        string class;
    }

    Student[] private students;

    function addStudent(string memory name, uint256 rollno, string memory class) public {
        students.push(Student(name, rollno, class));
    }

    function getStudentByRollNo(uint256 rollno) public view returns (string memory, uint256, string memory) {
        for (uint256 i = 0; i < students.length; i++) {
            if (students[i].rollno == rollno) {
                return (students[i].name, students[i].rollno, students[i].class);
            }
        }
        revert("Student with given roll number not found");
    }

    function getTotalNumberOfStudents() public view returns (uint256) {
        return students.length;
    }
}
