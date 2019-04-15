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

public class TopDown {

    @Test
    public void studentAssignment(){
        try{
            test_addStudent();
            addValidAssignment();
        }catch (Error e){
            assertTrue(false);
        }
    }

    @Test
    public void studentAssignmentGrade(){
        try{
            test_addStudent();
            addValidAssignment();
            addValidGrade();
        }catch (Error e){
            assertTrue(false);
        }
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
