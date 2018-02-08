package DB.DAO;

import DB.POJO.BaseCases;

import java.sql.SQLException;
import java.util.List;

public interface BaseCasesDAO {
    public void writeData(String string, long date,int id);
    public List<BaseCases> readData(int id1 ) throws SQLException;
}
