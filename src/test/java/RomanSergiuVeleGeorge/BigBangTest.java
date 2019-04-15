package RomanSergiuVeleGeorge;

import Domain.Student;
import Repository.NoteRepo;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Service.ServiceNote;
import Service.ServiceStudent;
import Service.ServiceTeme;
import UI.UI;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemeValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BigBangTest {

    @Test
    public void bigBangTheory() {
        try {
            AppTest.addValidAssignment();
            AppTest.test_addStudent();
            addValidGrade();
        } catch (Error e) {
            assertTrue(false);
        }
    }

    @Test
    public void addValidGrade() {
        try {
            StudentRepo rep=new StudentRepo(new StudentValidator(),"D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            TemeRepo repo=new TemeRepo(new TemeValidator(),"D:\\vvss\\LabAssiAsseProjectV04\\src\\teme.xml");
            NoteRepo r=new NoteRepo(new NotaValidator());
            ServiceStudent srv=new ServiceStudent(rep);
            ServiceTeme serv=new ServiceTeme(repo);
            ServiceNote sv=new ServiceNote(r);
            UI ui = new UI(srv, serv, sv);

            ui.addAssignment(1, "something", 3, 5);
            srv.add(new Student("1", "Daniel", 936, "preasfintitu.dani@saraki.ro", "Andreea Vescan"));
            ui.addGrade("1", 1, 10.0f, 4, "Fenomenal este ca sunt fenomenal");
            assertTrue(true);

        } catch (Error e) {
            assertTrue(false);
        }
    }
}
