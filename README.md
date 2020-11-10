GET:

student-manager/api/v1/student/all

Get list of all students



student-manager/api/v1/student/1

Get one student by ID 1
_____________________________
POST:

student-manager/api/v1/student/add

{
	"firstName": "Johanna",
	"lastname": "Svallingson",
	"email": "hello@johanna.com"
}

Add one student

_____________________________
PUT:

student-manager/api/v1/student/update

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

student-manager/api/v1/student/1

Delete student by ID 1