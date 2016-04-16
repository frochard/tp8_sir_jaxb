import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import enchere.xml.*;
import enchere.xml.impl.EnchereTypeImpl;
import enchere.xml.impl.PersonneTypeImpl;

public class Creer {   
    public static void main( String[] args ) {
        try {
            JAXBContext jc = JAXBContext.newInstance( "enchere.xml" );
            ObjectFactory factory = new ObjectFactory();
            //Cr�ation des objets � faire
             EnchereType enchere1 = new EnchereTypeImpl();
             enchere1.setTitre("Ferrari 335 S");
             enchere1.setDescriptif(" L'une des voitures de course parmi les plus glorieuses de la firme italienne: l'une des cinq barquettes 335");
             enchere1.setPrix(1000000);
             enchere1.setMeilleurPrix("32000000");
             //Cr�ation du propri�taire
             PersonneType p1=new PersonneTypeImpl();
             p1.setLogin("invit�");
             p1.setNom("Anonyme");
             p1.setPrenom("Anonyme");
             p1.setMail("contact@enchere.org");
             enchere1.setPropri�taire(p1);

             Marshaller m = jc.createMarshaller();
             m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
             m.marshal(enchere1, System.out);
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
