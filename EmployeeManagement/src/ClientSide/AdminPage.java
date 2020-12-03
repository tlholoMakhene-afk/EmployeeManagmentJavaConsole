package ClientSide;

public class AdminPage {

	public static void main(Object[] args) {
		// TODO Auto-generated method stub
		CurrentUser TempUser = (CurrentUser) args[0];
		System.out.println("Admin User -- "+ TempUser.getsUsername() +" --");
		System.out.println("Under Construction");
		ClientSideMethods.DisplayAdminTaskMenu();
	}

}
