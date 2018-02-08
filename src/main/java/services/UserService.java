package services;

import DB.DAO.*;
import DB.POJO.BaseCases;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserService {

    private static UserLoginDAO userLoginDAO = new UserLoginDaoImpl();
    private static UserPersonalDAO userPersonalDAO = new UserPersonalDaoImpl();
    private static BaseCasesDAO baseCasesDAO=new BaseCasesDaoImpl();

    public int checkAuth (String login, String password) throws SQLException {
        return  userLoginDAO.authClient(login,password);
    }
    public void writeData(String s, long d,int id1 ){
        baseCasesDAO.writeData(s,d,id1);
    }
    public List<BaseCases> readData(int id1 ) throws SQLException {
        return baseCasesDAO.readData(id1);
    }
}
