import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import enchere.xml.*;
import enchere.xml.impl.EnchereTypeImpl;

public class Transform {
	public static void main(String[] args) {
		try {
			JAXBContext jc = JAXBContext.newInstance("enchere.xml");
			Unmarshaller u = jc.createUnmarshaller();
			EnchereTypeImpl en = (EnchereTypeImpl)u.unmarshal(new FileInputStream("xml/test.xml"));
			// Ecrire un printer pour la liste des enchere récupérer
			System.out.println("Titre : "+en.getTitre());
			System.out.println("Descriptif : "+en.getDescriptif());
			System.out.println("Prix : "+en.getPrix());
			System.out.println("Meilleur prix : "+en.getMeilleurPrix());
			System.out.println("Propriétaire : "+en.getPropriétaire().toString());
			
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
