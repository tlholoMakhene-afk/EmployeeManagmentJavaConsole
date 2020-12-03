package ClientSide;

import HelperLiabrary.Encryption;

public class CurrentUser {
	
	private String sUsername;

	private String sPassword;
	private String type;
	
	public String getsUsername() {
		String decrptedusername = Encryption.caesarCipherDecrypte(sUsername);
		return decrptedusername ;
	}
	public void setsUsername(String sUsername) {
		String encrptyedString = Encryption.caesarCipherEncrypt(sUsername);
		this.sUsername = encrptyedString;
	}
	public String getsPassword() {
		String decrptedpass = Encryption.caesarCipherDecrypte(sPassword);
		return decrptedpass ;
		
	}
	public void setsPassword(String sPassword) {
		String encrptyedString = Encryption.caesarCipherEncrypt(sPassword);
	
		this.sPassword = encrptyedString;
	}
	public String getType() {
		String decrString = Encryption.caesarCipherDecrypte(type);
		return decrString ;
	}
	public void setType(String type) {
		String encString  = Encryption.caesarCipherEncrypt(type);
		this.type = encString;
	}
	
	
	@Override
	public String toString() {
		return "CurrentUser [sUsername=" + sUsername + ", sPassword=" + sPassword + ", type=" + type + "]";
	}
	public CurrentUser()
	{
		
	}
	

	
}
