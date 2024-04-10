package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "222342946";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Vishal";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testEmptyUsernameEmptyPasswordEmptyCode() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse("Expected login failure for empty username and password", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameValidPasswordEmptyCode() {
        LoginStatus status = LoginForm.login(null, "123456");
        Assert.assertFalse("Expected login failure for empty username", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }
    
    @Test
    public void testEmptyUsernameInvalidPasswordEmptyCode() {
        LoginStatus status = LoginForm.login(null, "invalidPassword");
        Assert.assertFalse("Expected login failure for empty username", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }
    
    @Test
    public void testValidUsernameEmptyPasswordEmptyCode() {
        LoginStatus status = LoginForm.login("username", null);
        Assert.assertFalse("Expected login failure for empty password", status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }
    
    @Test
    public void testValidUsernameValidPasswordEmptyCode() {
        LoginStatus status = LoginForm.login("username", "123456");
        Assert.assertFalse("Expected credential mismatch", status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }
    
    @Test
    public void testValidUsernameInvalidPasswordEmptyCode() {
        LoginStatus status = LoginForm.login("username", "invalidPassword");
        Assert.assertFalse("Expected credential mismatch", status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }
    
    @Test
    public void testValidUsernameEmptyPasswordValidCode() {
        LoginStatus status = LoginForm.login("username", null);
        Assert.assertFalse("Expected login failure for empty password", status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }
    
    @Test
    public void testValidUsernameValidPasswordValidCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue("Expected successful login", status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
    }
    
    @Test
    public void testValidUsernameInvalidPasswordValidCode() {
        LoginStatus status = LoginForm.login("username", "invalidPassword");
        Assert.assertFalse("Expected credential mismatch", status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }`
    
    @Test
    public void testValidUsernameEmptyPasswordInvalidCode() {
        LoginStatus status = LoginForm.login("username", null);
        Assert.assertFalse("Expected login failure for empty password", status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }
    
    @Test
    public void testValidUsernameValidPasswordInvalidCode() {
        LoginStatus status = LoginForm.login("username", "password");
        Assert.assertFalse("Expected invalid validation code", status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }
}