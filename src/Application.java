import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sai.config.AppConfig;
import com.sai.controller.MainController;
import com.sai.vo.EmployeeVO;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MainController controller = context.getBean(MainController.class);
		Scanner sc = new Scanner(System.in);
		EmployeeVO vo = new EmployeeVO();

		while (true) {

			System.out.println("1.Insert 2.Search \n Enter your Choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter id: ");
				vo.setId(sc.next());
				System.out.println("Enter name: ");
				vo.setName(sc.next());		
				System.out.println("Enter age: ");
				vo.setAge(sc.next());
				System.out.println("Enter city: ");
				vo.setCity(sc.next());
				System.out.println(controller.insert(vo));
				break;
			case 2:
				System.out.println("Enter id: ");
				System.out.println(controller.search(sc.nextInt()));
				break;
			default:
				System.out.println("Invalid Input");
			}
			
			System.out.println("Do you want to Continue ?(yes/no): ");
			String cont = sc.next();
			if(cont.equalsIgnoreCase("yes"))
				continue;
			else
				break;
		}
		
		sc.close();
		((AbstractApplicationContext) context).close();
	}
}
