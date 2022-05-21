
package User;
import Subjects.StudentSubject;
public class Student extends User{
    
    int AUD;
    StudentSubject[] subjects = new StudentSubject[10];
    int TotalSubjects;
    public Student(String n,String p,int id,String subs[]){
        super(n,p);
        AUD = id;
        TotalSubjects = subs.length;
        for(int i=0;i<subs.length;i++){
            subjects[i] = new StudentSubject(subs[i]);
        }
        
    }
    
    public int GetAUD(){
        return AUD;
    }
    
    public int GetTotalSubjects(){
        return TotalSubjects;
    }
    
    public void Display(){
        System.out.println("Student Name : " + name);
        System.out.println("Student Pass : " + pass);
        System.out.println("AUD : " + AUD);
        System.out.println("Subjects : ");
        for(int i=0;i<TotalSubjects;i++){
            System.out.println(" - "+subjects[i].GetSubjectName());
        }
    }
    
    public String GetSubjectByIndex(int i){
        return subjects[i].GetSubjectName();
    }
    public void ModifyMarks(int index,int x){
        subjects[index].ModifyMarks(x);
    }
    
    public void DisplaySubjects(){
        System.out.println("Subjects : ");
        for(int i=0;i<TotalSubjects;i++){
            System.out.println(" - "+subjects[i].GetSubjectName());
        }
    }
    
    public void DisplayMarks(){
        System.out.println("Subjects : ");
        for(int i=0;i<TotalSubjects;i++){
            System.out.println(subjects[i].GetSubjectName() + " : " + subjects[i].GetMarks());
        }
    }
}
