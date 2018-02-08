package DB.POJO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class UserPersonal {
    private int id;
    private String first_name;
    private String last_name;
    private String second_name;
    private Date birthday;
    private String sex;
    private String proffesion;

    @Override
    public String toString() {
        return "UserPersonal{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", proffesion='" + proffesion + '\'' +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }
    @XmlElement
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public UserPersonal(){}

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }
    @XmlElement
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }
    @XmlElement
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSecond_name() {
        return second_name;
    }
    @XmlElement
    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }


    public String getSex() {
        return sex;
    }
    @XmlElement
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProffesion() {
        return proffesion;
    }
    @XmlElement
    public void setProffesion(String proffesion) {
        this.proffesion = proffesion;
    }

    public UserPersonal(int id, String first_name, String last_name, String second_name, Date birthday, String sex, String proffesion) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.birthday = birthday;
        this.sex = sex;
        this.proffesion = proffesion;
    }
}
