package se.iths.validator;

import se.iths.entity.Student;
import se.iths.exception.InvalidInputException;

public class InputValidator {


    public void validateStudentInput(Student student){
        if(student.getFirstName() == null || student.getLastname() == null || student.getEmail() == null){
            String message = createMessage(student);
            throw new InvalidInputException(message);
        }
    }

    private String createMessage(Student student) {
        StringBuilder message = new StringBuilder();
        if(student.getFirstName() == null){
            message.append("First name must be specified \n");
        }
        if(student.getLastname() == null){
            message.append("Lastname must be specified \n");
        }
        if(student.getEmail() == null){
            message.append("Email must be specified \n");
        }
        return message.toString();
    }
}
