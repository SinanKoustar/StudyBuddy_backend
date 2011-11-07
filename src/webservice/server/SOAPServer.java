package webservice.server;

import webservice.service.SOAPService;

import javax.xml.ws.Endpoint;

/**
 * @author asteinbr
 * @date 11/7/11
 */
public class SOAPServer
{
    SOAPService soapService = new SOAPService();
    Endpoint endpoint = Endpoint.publish("http://localhost:1337/SOAPService", soapService);
}
