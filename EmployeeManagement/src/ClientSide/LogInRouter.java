package ClientSide;

import java.util.Scanner;

import ClientSide.StandardTasks.task;

public class LogInRouter {

	public enum AdminMenu
	{
		standard,
		admin,
		exit
	}
	public static void main(Object[] args) {
		// TODO Auto-generated method stub
		

CurrentUser TempUser = (CurrentUser) args[0];

System.out.println("Welcome: " + TempUser.getsUsername());
 
if(TempUser.getType().equals("Admin")) {
	boolean bapp = true;
	
	do
	{
	ClientSideMethods.DisplayAdminMenu();
	Scanner myscannerobj = new Scanner(System.in);
	int choice = Integer.parseInt(myscannerobj.nextLine());
	if(choice>= 4)
	{
		return;
	}
	AdminMenu taskchoice = AdminMenu.values()[choice-1];
	switch (taskchoice) {
	case admin:
		AdminPage.main(new Object[] {TempUser});
		break;
	case standard:
		StandardTasks.main(new Object[] {TempUser});
		break;
	case exit:
		ClientSide.main(new String[] {});
		break;

	default:
		System.out.println("Invalid Entry");
		break;
	}
	}while(bapp == true);
	
}
else if(TempUser.getType().equals("Normal"))
{StandardTasks.main(new Object[] {TempUser} );}
	else {System.out.println("Invalid type  ");}

}
	}
