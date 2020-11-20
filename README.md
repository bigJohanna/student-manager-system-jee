The project loads with sample data on startup. <br>
Labb1 on branch main. <br>
Labb2 on branch main2. <br>

__Main__ <br>

GET:

http://localhost:8080/student-manager/api/v1/student/all<br>
Get list of all students

http://localhost:8080/student-manager/api/v1/student/1 <br>
Get one student by ID 1

http://localhost:8080/student-manager/api/v1/student/lastname?lastname=West <br>
Get student(s) by lastname.

___
POST:

http://localhost:8080/student-manager/api/v1/student/add <br>
{
	"firstName": "Johanna",
	"lastname": "Svallingson",
	"email": "hello@johanna.com"
} <br>
Add one student

___
PUT:

http://localhost:8080/student-manager/api/v1/student/update <br>
{
        "id":1,
        "firstName": "Johanna",
    	"lastname": "Svallingson",
    	"email": "hello@johanna.com",
    	"phoneNumber": "0700607080"
} 
<br>
Update student by ID 1

___
DELETE:

http://localhost:8080/student-manager/api/v1/student/1 <br>
Delete student by ID 1


 __Main2__

GET:

http://localhost:8080/student-manager/api/v1/teacher/all <br>
All teachers

http://localhost:8080/student-manager/api/v1/subject/all <br>
All subjects
<br>
<br>
<br>

http://localhost:8080/student-manager/api/v1/teacher/subjects/{teacher-id} <br>
All subjects by teacher ID

>End points to be implemented:
>http://localhost:8080/student-manager/api/v1/subject/students/{subject-id} <br>
>All students by subject ID
>
>http://localhost:8080/student-manager/api/v1/teacher/students/{teacher-id}/{subject-id} <br>
>All students by teacher ID and subject ID
>
