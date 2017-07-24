package org.aivan.ratauth.mongo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class UtilTest {

    Properties goodProps;
    Properties badProps;
    
    @Before
    public void setup() {
        goodProps = new Properties();
        goodProps.setProperty("mongo_hostname", "192.168.99.100");
        goodProps.setProperty("mongo_port", "1234");
        
        badProps = new Properties();
        badProps.setProperty("mongo_hostnameXXX", "192.168.99.100");
        badProps.setProperty("mongo_portXXX", "1234");
    }
    
  @Test
  public void loadApplicationProperties() throws IOException {
      Properties p = Util.loadApplicationProperties();
      assertNotNull(p);
  }
  
  @Test
  public void getMongoHostnameDefault() throws IOException {
      assertEquals("localhost", Util.getMongoHostname(badProps));
  }
  
  @Test
  public void getMongoHostnameNonDefault() throws IOException {
      assertEquals("192.168.99.100", Util.getMongoHostname(goodProps));
  }
  
  @Test
  public void getMongoPortDefault() throws IOException {
      assertEquals(27017, Util.getMongoPort(badProps));
  }
  
  @Test
  public void getMongoPortNonDefault() throws IOException {
      assertEquals(1234, Util.getMongoPort(goodProps));
  }
}
