package generated/src/main/java.org.metafactory.tutorial.example1.core.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Business1 - Created by MetaFactory: Automation of Software Development
 * 
 * @author - Merijn
 */
public class Business1
{
  /** The package name */
  private String ID = "generated/src/main/java.org.metafactory.tutorial.example1.core.model";

  /** Classname in capitals */
  private String ClassID = "BUSINESS1";

  private static final Logger LOG = LoggerFactory.getLogger(Business1.class.getName());

  /**
   * methode1 - 
   * @return String 
   */
  protected String  methode1() 
  {
    LOG.debug("Hello World");
        LOG.debug("ID=" + ID);
        LOG.debug("ClassID=" + ClassID);
        return "Hello World";
  }

}
