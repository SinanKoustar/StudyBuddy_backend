package webservice.service;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

/**
 * @author asteinbr
 * @date 11/7/11
 */
public class SOAPService {
    public String test()
    {
        return new String("Hello");
    }
}
