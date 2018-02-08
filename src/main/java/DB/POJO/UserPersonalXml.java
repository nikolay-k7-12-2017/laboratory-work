package DB.POJO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.GregorianCalendar;

public class UserPersonalXml {


    public static void main(String[] args) throws JAXBException {

        UserPersonal userPersonal =
                new UserPersonal(1
                        ,"harry"
                        ,"potter"
                        ,"ivanovich"
                        , (new GregorianCalendar(2010,01,16)).getTime()
                        ,"magigMan"
                        ,"magigTractorist");

        JAXBContext context = JAXBContext.newInstance(UserPersonal.class);
        Marshaller marshaller  =  context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(userPersonal,System.out);
    }
}
