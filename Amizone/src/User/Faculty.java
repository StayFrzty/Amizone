
package User;
import Subjects.Subject;
public class Faculty extends User{
    
    int FacultyID;
    Subject[] subjects = new Subject[10];
    int TotalSubjects;
    public Faculty(String n,String p,int fID,String subs[]){
        super(n,p);
        FacultyID = fID;
        TotalSubjects = subs.length;
        for(int i=0;i<subs.length;i++){
            subjects[i] = new Subject(subs[i]);
        }
    }
    
    public Subject[] GetSubjects(){
        return subjects;
    }
    
    public int GetTotalSubjects(){
        return TotalSubjects;
    }
    
    public int GetFacultyID(){
        return FacultyID;
    }
    
    public void Display(){
        System.out.println("Faculty Name : " + name);
        System.out.println("Faculty Pass : " + pass);
        System.out.println("Faculty ID : " + FacultyID);
        System.out.println("Subjects : ");
        for(int i=0;i<TotalSubjects;i++){
            System.out.println(" - "+subjects[i].GetSubjectName());
        }
    }
    
    public void DisplaySubjects(){
        System.out.println("Subjects : ");
        for(int i=0;i<TotalSubjects;i++){
            System.out.println(" - "+subjects[i].GetSubjectName());
        }
    }
    
    public String GetSubjectByIndex(int i){
        return subjects[i].GetSubjectName();
    }
    
}
