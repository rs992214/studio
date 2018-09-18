package es.iessaladillo.pedrojoya.pr014.ui.main;

import android.arch.lifecycle.ViewModel;

import java.util.List;

import es.iessaladillo.pedrojoya.pr014.data.Repository;
import es.iessaladillo.pedrojoya.pr014.data.local.model.Student;

@SuppressWarnings("WeakerAccess")
public class MainActivityViewModel extends ViewModel {

    private List<Student> students;
    private final Repository repository;

    public MainActivityViewModel(Repository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        if (students == null) {
            students = repository.queryStudents();
        }
        return students;
    }

    public void deleteStudent(Student student) {
        repository.deleteStudent(student);
    }

}
