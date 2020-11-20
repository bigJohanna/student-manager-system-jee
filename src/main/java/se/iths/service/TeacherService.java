package se.iths.service;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Teacher createTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    public Teacher updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
        return teacher;
    }

    public Teacher findTeacherById(Long id) {

        return entityManager.find(Teacher.class, id);
    }


    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("SELECT t from Teacher t", Teacher.class).getResultList();
    }

    public void deleteTeacher(Long id){
        Teacher deleteThis = entityManager.find(Teacher.class, id);
        entityManager.remove(deleteThis);
    }

    public Set<Subject> getAllSubjects(Long id) {
        return entityManager.find(Teacher.class, id).getSubjects();
    }
}
