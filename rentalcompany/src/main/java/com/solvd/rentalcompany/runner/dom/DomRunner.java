package com.solvd.rentalcompany.runner.dom;

import com.solvd.rentalcompany.runner.DAORunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomRunner {
    private static final Logger LOGGER = LogManager.getLogger(DAORunner.class);
    public static void main (String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/main/resources/users.xml");
            NodeList userList = document.getElementsByTagName("user");
            for (int i = 0; i < userList.getLength(); i++) {
                Node user = userList.item(i);
                if (user.getNodeType() == Node.ELEMENT_NODE) {
                    Element userElement = (Element) user;
                    String user_id = userElement.getAttribute("user_id");
                    NodeList userNodeList = userElement.getChildNodes();
                    for (int j = 0; j < userNodeList.getLength(); j++) {
                        Node userNode = userNodeList.item(j);
                        if(userNode.getNodeType() == Node.ELEMENT_NODE && !userNode.getNodeName().equals("license")) {
                            Element u_nameE = (Element) userNode;
                            System.out.println("User " + user_id + ": " + u_nameE.getTagName() + " = " + u_nameE.getTextContent());
                        } else if (userNode.getNodeType() == Node.ELEMENT_NODE && userNode.getNodeName().equals("license")) {
                            Element u_nameE = (Element) userNode;
                            System.out.println("User " + user_id + ": " + u_nameE.getTagName() + " = " + u_nameE.getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
}
