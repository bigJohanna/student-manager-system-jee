The project loads with sample data on startup.

Labb1 on branch main. <br>
Labb2 on branch main2.

__MAIN:__

GET:

http://localhost:8080/student-manager/api/v1/student/all

Get list of all students

--

http://localhost:8080/student-manager/api/v1/student/1

Get one student by ID 1

--

http://localhost:8080/student-manager/api/v1/student/lastname?lastname=West

Get student(s) by lastname.

_____________________________
POST:

http://localhost:8080/student-manager/api/v1/student/add

{
	"firstName": "Johanna",
	"lastname": "Svallingson",
	"email": "hello@johanna.com"
}

Add one student

_____________________________
PUT:

http://localhost:8080/student-manager/api/v1/student/update

{
        "id":1,
        "firstName": "Johanna",
    	"lastname": "Svallingson",
    	"email": "hello@johanna.com",
    	"phoneNumber": "0700607080"
}

Update student by ID 1

_____________________________
DELETE:

http://localhost:8080/student-manager/api/v1/student/1

Delete student by ID 1