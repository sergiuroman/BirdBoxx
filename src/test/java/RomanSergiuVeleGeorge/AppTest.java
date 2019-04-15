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

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test_addStudent() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), "D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            Student std = new Student("78", "Sergiu", 936, "sergiu97@yahoo.ro", "Prof X");
            srv.add(std);
            assertTrue(true);
        } catch (Error e) {
            assertTrue(false);
        }
    }

    @Test
    public void addStudentWithInvalidEmail() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), "D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", "Sergiu", 936, "e-mail", "Prof X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }    }

    @Test
    public void addStudentWithNullEmail() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), "D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", "Sergiu", 936, null, "Prof X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }       }

    @Test
    public void addStudentWithInvalidGroup() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), "D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", "Sergiu", 189, "jojo@ghdd.com", "Prof X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }      }

    @Test
    public void addStudentWithNullName() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), "D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", null, 933, "jojo@ghdd.com", "Prof X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }        }

    @Test
    public void addStudentWithNullProfessor() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), "D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", "Sergiu", 933, "jojo@ghdd.com", null);
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void addStudentWithInvalidProfessor() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), "D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("78", "Sergiu", 935, "jojo@ghdd.com", "Prof 66X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void addStudentWithInvalidID() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), "D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);
            Student std = new Student("7j8", "Sergiu", 934, "jojo@ghdd.com", "Prof X");
            srv.add(std);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void addValidAssignment() {
        try {
            StudentRepo rep = new StudentRepo(new StudentValidator(), "D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            TemeRepo repo = new TemeRepo(new TemeValidator(), "D:\\vvss\\LabAssiAsseProjectV04\\src\\teme.xml");
            NoteRepo r = new NoteRepo(new NotaValidator());
            ServiceStudent srv = new ServiceStudent(rep);
            ServiceTeme serv = new ServiceTeme(repo);
            ServiceNote sv = new ServiceNote(r);
            UI ui = new UI(srv, serv, sv);
            ui.addAssignment(1, "Do black box testing", 2, 3);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void addInvalidAssignment() {
        try {
            StudentRepo rep=new StudentRepo(new StudentValidator(),"D:\\vvss\\LabAssiAsseProjectV04\\src\\studenti.xml");
            TemeRepo repo=new TemeRepo(new TemeValidator(),"D:\\vvss\\LabAssiAsseProjectV04\\src\\teme.xml");
            NoteRepo r=new NoteRepo(new NotaValidator());
            ServiceStudent srv=new ServiceStudent(rep);
            ServiceTeme serv=new ServiceTeme(repo);
            ServiceNote sv=new ServiceNote(r);
            UI ui=new UI(srv,serv,sv);
            ui.addAssignment(1, "dO wHiTeBoX tEsTiNg", 3, 1);
            assertTrue(false);
        } catch (Error e) {
            assertTrue(true);
        }
    }
}
