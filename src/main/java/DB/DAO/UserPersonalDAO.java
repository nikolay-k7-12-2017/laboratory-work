package DB.DAO;



import java.util.Date;
import java.util.List;

public interface UserPersonalDAO {

    void regClient(String first_name, String last_name,
                   String second_name, Date birtday, String sex, String proffesion);
}
