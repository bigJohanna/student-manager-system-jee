package se.iths.validator;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.exception.InvalidInputException;

public class InputValidator {


    public void validateStudentInput(Student student){
        if(student.getFirstName() == null || student.getLastname() == null || student.getEmail() == null){
            String message = createMessage(student);
            throw new InvalidInputException(message);
        }
    }


    public void validateTeacherInput(Teacher teacher) {


    }

    public void validateSubjectInput(Subject subject) {

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

    private String createMessage(Teacher teacher){
        return "Body should look like this:\n" +
                "";
    }

    private String createMessage(Subject subject){
        return "Body should look like this:\n" +
                "";
    }


}
