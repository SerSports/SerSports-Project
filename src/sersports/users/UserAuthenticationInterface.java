package sersports.users;

public interface UserAuthenticationInterface 
{
	// Returns true if the user is authenticate
	Boolean authenticateUser(String userName, String password);
	// Return true if a user is added
	Boolean addUser(String userName, String password);
}
