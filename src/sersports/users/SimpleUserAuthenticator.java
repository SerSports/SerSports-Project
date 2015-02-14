package sersports.users;

// Extremely Simple User Authenticator used as a place holder.
// To log in, use the following information:
//		userName = "profgary"
//		password = "thebest"
//
public class SimpleUserAuthenticator implements UserAuthenticationInterface 
{
	@Override
	public Boolean authenticateUser(String userName, String password) 
	{
		// Extremely simple validation
		return (userName.equals("profgary") && password.equals("thebest"));
	}

	@Override
	public Boolean addUser(String userName, String password) 
	{
		return true;
	}
}
