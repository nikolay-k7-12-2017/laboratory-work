package DB.POJO;

import java.util.Date;

public class UserLogin {
    private int id;
    private int id_personal;
    private UserPersonal userPersonal;
    private String login;
    private String password;
    private Date date_reg;

    public UserLogin(){}

    public UserLogin(int id, UserPersonal userPersonal, String login, String password, Date date_reg) {
        this.id = id;
        this.userPersonal = userPersonal;
        this.login = login;
        this.password = password;
        this.date_reg = date_reg;
    }

    public UserLogin(int id, int id_personal, String login, String password, Date date_reg) {

        this.id = id;
        this.id_personal = id_personal;
        this.login = login;
        this.password = password;
        this.date_reg = date_reg;
    }

    public UserLogin(int id, int id_personal, String login, String password) {
        this.id = id;
        this.id_personal = id_personal;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public UserPersonal getUserPersonal() {
        return userPersonal;
    }

    public void setUserPersonal(UserPersonal userPersonal) {
        this.userPersonal = userPersonal;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_reg() {
        return date_reg;
    }

    public void setDate_reg(Date date_reg) {
        this.date_reg = date_reg;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", id_personal=" + id_personal +
                ", userPersonal=" + userPersonal +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", date_reg=" + date_reg +
                '}';
    }
}
