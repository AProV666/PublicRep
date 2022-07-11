import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        try {
            if (qName.equals("voter")) {
                String name = attributes.getValue("name");
                String birthDate = attributes.getValue("birthDay");
                try {
                    DBConnection.countVoter(name, birthDate);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
