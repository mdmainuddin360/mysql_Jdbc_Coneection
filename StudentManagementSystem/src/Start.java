import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {
public static void main(String[] args) throws IOException {
	System.out.println("Wel come to Student management System ");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	while(true ) {
		System.out.println("press 1 for add");
		System.out.println("press 2 for delete");
		System.out.println("prees 3 for display");
		System.out.println("press 4 for exit");
		int c=Integer.parseInt(br.readLine());
		if(c==1) {
			System.out.println("Enter Name");
			String name=br.readLine();
			System.out.println("Enter phone");
			String phone =br.readLine();
			System.out.println("Enter city");
			String city=br.readLine();
			Student st=new Student(name,phone,city);
			boolean ans=StudentDao.insertDB(st);
			if(ans) {
				System.out.println("succesfully added ");
			}
			else {
				System.out.println("something went worng");
			}
		}
		else if(c==2) {
			System.out.println("Enter Student id to delete");
			int id=Integer.parseInt(br.readLine());
			boolean ans=StudentDao.deleteStudent(id);
			if(ans) {
				System.out.println("succesfully deleted ");
			}
			else {
				System.out.println("something went worng");
			}
		}
		else if(c==3) {
			
			
			
			StudentDao.showAllStudent();
		}
		else if(c==4) {
			break;
		}
	}
}
}
