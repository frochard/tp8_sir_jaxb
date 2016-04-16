import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import enchere.xml.*;
import enchere.xml.impl.EnchereTypeImpl;

public class Validate {
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance("enchere.xml");
            Unmarshaller u = jc.createUnmarshaller();
            //EnchereType en = (EnchereTypeImpl)u.unmarshal(new FileInputStream("xml/test.xml"));
            EnchereType en = (EnchereTypeImpl)u.unmarshal(new FileInputStream("xml/test_err.xml"));
            System.out.println( "validation reussie !");                       
        } catch( UnmarshalException ue ) {
            System.out.println("mauvaise validation ! " + ue.getMessage());
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
