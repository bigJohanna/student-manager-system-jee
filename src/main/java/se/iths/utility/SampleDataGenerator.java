package se.iths.utility;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup //klassen körs när den startas
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct // så fort bönan är skapad körs metoden.
    public void generateData() {

        Student stu1 = new Student("Carina", "Higgins", "c.higgins@randatmail.com", "819-3629-69");
        Student stu2 = new Student("Abraham", "Johnston", "a.johnston@randatmail.com", "546-4404-85");
        Student stu3 = new Student("Lucy", "Hunt", "l.hunt@randatmail.com", "488-5437-64");
        Student stu4 = new Student("Mary", "Anderson", "m.anderson@randatmail.com", "804-4798-53");
        Student stu5 = new Student("Byron", "West", "b.west@randatmail.com", "541-7893-67");
        Student stu6 = new Student("Ashton", "Ellis", "a.ellis@randatmail.com", "089-2743-59");

        Subject sub1 = new Subject("Computer Science");
        Subject sub2 = new Subject("Complex Java");
        Subject sub3 = new Subject("Micro Services");

        Teacher t1 = new Teacher("Rose Mary");
        Teacher t2 = new Teacher("Anna Mae");

        t1.addSubject(sub1);
        t1.addSubject(sub2);
        t2.addSubject(sub3);

        sub1.addStudent(stu1);
        sub1.addStudent(stu2);
        sub1.addStudent(stu3);
        sub2.addStudent(stu1);
        sub2.addStudent(stu5);
        sub2.addStudent(stu6);
        sub3.addStudent(stu1);

        entityManager.persist(stu1);
        entityManager.persist(stu2);
        entityManager.persist(stu3);
        entityManager.persist(stu4);
        entityManager.persist(stu5);
        entityManager.persist(stu6);

        entityManager.persist(t1);
        entityManager.persist(t2);









    }


}