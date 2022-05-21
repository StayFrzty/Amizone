
package Subjects;

public class StudentSubject extends Subject {
    int Marks;
    int totalSubjects;
    public StudentSubject(String s){
        super(s);
        Marks = 0;
    }
    
    public int GetMarks(){
        return Marks;
    }
    
    public void ModifyMarks(int x){
        Marks = x;
    }
    
}
