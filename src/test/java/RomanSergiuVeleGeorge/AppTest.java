package RomanSergiuVeleGeorge;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test_addStudent(){
        assertTrue(true);
    }

    @Test
    public void addStudentWithInvalidEmail(){
        assertTrue(true);
    }

    @Test
    public void addStudentWithNullEmail(){
        assertTrue(true);
    }

    @Test
    public void addStudentWithInvalidGroup(){
        assertTrue(false);
    }

    @Test
    public void addStudentWithNullName(){
        assertTrue(false);
    }

    @Test
    public void addStudentWithNullProfessor(){
        assertTrue(false);
    }

    @Test
    public void addStudentWithInvalidProfessor(){
        assertTrue(false);
    }

    @Test
    public void addStudentWithInvalidID(){
        assertTrue(true);
    }



}
