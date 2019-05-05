public class UserServiceImpl {
    private IUserDao userDAO;

    private ISecurityService securityService;

    public void assignPassword(User user) throws Exception {

        String passwordMd5 = securityService.md5(user.get_password());
        user.set_password(passwordMd5);

        userDAO.updateUser(user);

    }

    public UserServiceImpl(IUserDao dao, ISecurityService security) {
        this.userDAO = dao;
        this.securityService = security;
    }
}
