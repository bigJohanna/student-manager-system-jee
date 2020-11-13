package se.iths.utility;

import se.iths.entity.Student;

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

        entityManager.persist(new Student("Carina", "Higgins", "c.higgins@randatmail.com", "819-3629-69"));
        entityManager.persist(new Student("Abraham", "Johnston", "a.johnston@randatmail.com", "546-4404-85"));
        entityManager.persist(new Student("Lucy", "Hunt", "l.hunt@randatmail.com", "488-5437-64"));
        entityManager.persist(new Student("Mary", "Anderson", "m.anderson@randatmail.com", "804-4798-53"));
        entityManager.persist(new Student("Byron", "West", "b.west@randatmail.com", "541-7893-67"));
        entityManager.persist(new Student("Ashton", "Ellis", "a.ellis@randatmail.com", "089-2743-59"));

    }

}