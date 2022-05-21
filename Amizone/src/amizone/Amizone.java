
package amizone;
import java.util.Scanner;
import User.Faculty;
import User.Student;
import Subjects.Subject;
public class Amizone {

    public static boolean NotIn(int[] arr,int number,int totalS){
        for(int i=0;i<totalS;i++){
          if(arr[i] == number){
              return false;
          }  
        }
        return true;
    }
    
    public static void EditMarks(Student students[],int StudentIndex,Subject[] subjects,int TotalSubjects){
        int choice;
        Scanner scan = new Scanner(System.in);
        
            System.out.println("Pick A Subject To Edit : ");
            for(int i=0;i<TotalSubjects;i++){
            System.out.println(" "+(i+1)+" "+subjects[i].GetSubjectName());
            }
            choice = scan.nextInt();
            choice--;
            int NewMarks;
            System.out.println("Enter The New Marks : ");
            NewMarks = scan.nextInt();
            
            for(int i=0;i<students[StudentIndex].GetTotalSubjects();i++){
                if(subjects[choice].GetSubjectName().equals(students[StudentIndex].GetSubjectByIndex(i))){
                    students[StudentIndex].ModifyMarks(i, NewMarks);
                    
                }
            }
            
         
    }
    
    public static void StudentLogin(Student students[],int LoggedInIndex){
         int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("     Welcome "+ students[LoggedInIndex].GetName() +"     ");
           do{
               System.out.println("1.Display Marks");
               System.out.println("2.Display Subjects");
               System.out.println("3.Log Out");
               choice = scan.nextInt();
               
               switch(choice){
                   case 1:
                       students[LoggedInIndex].DisplayMarks();
                   break;
                   case 2:
                       students[LoggedInIndex].DisplaySubjects();
                   break;
               }
               
           }while(choice != 3);
    }
    
    public static void FacultyLogin(Faculty faculties[],Student students[],int LoggedInIndex){
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("     Welcome "+ faculties[LoggedInIndex].GetName() +"     ");
           do{
               System.out.println("1.Mark Students");
               System.out.println("2.Display Subjects");
               System.out.println("3.Display All Students");
               System.out.println("4.Log Out");
               choice = scan.nextInt();
               
               switch(choice){
                   case 1:
                   {
                    
                    int IndexOfStudents[] = new int[30];
                    int totalS = 0;
                    for(int i=0;i<faculties[LoggedInIndex].GetTotalSubjects();i++){
                        for(int j=0;j<2;j++){
                            for(int k=0;k<students[j].GetTotalSubjects();k++){
                                if(faculties[LoggedInIndex].GetSubjectByIndex(i).equals(students[j].GetSubjectByIndex(k)) && NotIn(IndexOfStudents,j,totalS)){
                                     
                                    IndexOfStudents[totalS] = j;
                                    totalS++;
                                    break;
                                }
                            }
                        }
                    }
                    for(int i=0;i<totalS;i++){
                        System.out.println(" "+(i+1) + " - "+students[IndexOfStudents[i]].GetName());
                    }
                    System.out.println("Pick A Student To Add Marks To : ");
                    int index;
                    index = scan.nextInt();
                    index--;
                    EditMarks(students,index,faculties[LoggedInIndex].GetSubjects(),faculties[LoggedInIndex].GetTotalSubjects());
                   }
                   break;
                   
                   case 2:
                   faculties[LoggedInIndex].DisplaySubjects();
                   break;
                   
                   case 3:
                   {
                    int IndexOfStudents[] = new int[30];
                    int totalS = 0;
                    for(int i=0;i<faculties[LoggedInIndex].GetTotalSubjects();i++){
                        for(int j=0;j<2;j++){
                            for(int k=0;k<students[j].GetTotalSubjects();k++){
                                if(faculties[LoggedInIndex].GetSubjectByIndex(i).equals(students[j].GetSubjectByIndex(k)) && NotIn(IndexOfStudents,j,totalS)){
                                    IndexOfStudents[totalS] = j;
                                    totalS++;
                                    break;
                                }
                            }
                        }
                    }
                    for(int i=0;i<=totalS;i++){
                        System.out.println(" - "+students[IndexOfStudents[i]].GetName());
                    }
                    System.out.println("");
                   }
                   break;
               }
               
           }while(choice !=4);
    }
    
    public static void main(String[] args) {
        
        String[] s1 = {"Maths","Material Science"};
        String[] s2 = {"TOC","Java"};
        String[] s3 = {"Maths","Material Science","TOC","Java"};
        Student students[] = new Student[5];
        Faculty faculties[] = new Faculty[5];
        students[0] = new Student("Jhon","123",14848,s3);
        students[1] = new Student("Carl","123",15248,s3);
        faculties[0] = new Faculty("Ved","123",24,s2);
        faculties[1] = new Faculty("Sarath","123",28,s1);
        
        
        
        
           int choice;
           Scanner scan = new Scanner(System.in);
           do{
               System.out.println("1.Login As Faculty");
               System.out.println("2.Login As Student");
               System.out.println("3.Exit");
               choice = scan.nextInt();
               
               switch(choice){
                   case 1:
                   {
                   Scanner s = new Scanner(System.in);
                   String p;
                   int id;
                   int LoggedInIndex = -1;
                   System.out.println("Enter Faculty ID : ");
                   id = scan.nextInt();
                   System.out.println("Enter Faculty Password : ");
                   p = s.nextLine();
                   
                   for(int i=0;i<2;i++){
                       if(faculties[i].GetFacultyID() == id && faculties[i].GetPass().equals(p)){
                        LoggedInIndex = i;   
                       }
                   }
                   
                   if(LoggedInIndex != -1){
                       FacultyLogin(faculties,students,LoggedInIndex);
                   }else{
                       System.out.println("Invalid ID Or Password !");
                   }
                   }
                   break;
                   
                   case 2:
                   Scanner s = new Scanner(System.in);
                   String p;
                   int id;
                   int LoggedInIndex = -1;
                   System.out.println("Enter Student ID : ");
                   id = scan.nextInt();
                   System.out.println("Enter Student Password : ");
                   p = s.nextLine();
                   
                   for(int i=0;i<2;i++){
                       if(students[i].GetAUD() == id && students[i].GetPass().equals(p)){
                        LoggedInIndex = i;   
                       }
                   }

                   if(LoggedInIndex != -1){
                       StudentLogin(students,LoggedInIndex);
                   }else{
                       System.out.println("Invalid ID Or Password !");
                   }
                   break;
               }
               
           }while(choice !=3);
        
    }
    
}
