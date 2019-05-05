import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Test
    public void AssignPassword_Successfull() throws Exception {

        // Arrange
        String password = "1234";
        User user = new User();
        user.set_password("abc");

        // Setup- mocks
        IUserDao dao = Mockito.mock(IUserDao.class);
        ISecurityService securityService = Mockito.mock(ISecurityService.class);
        UserServiceImpl userService = new UserServiceImpl(dao, securityService);
        Mockito.when(securityService.md5(Mockito.any(String.class))).thenReturn(password);

        // Act
        userService.assignPassword(user);

        // Assert
        Assert.assertEquals(password, user.get_password());
        Mockito.verify(dao).updateUser(user);

    }

}