package hello;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class String2EmployeeIdIntegerConverter implements Converter<Object[], EmployeeId>{
    private static final Log LOGGER =  LogFactory.getLog(String2EmployeeIdIntegerConverter.class.getName());

    @Override
    public EmployeeId convert(Object o[]) {
    	String s = (String)o[0];
    	String myString[] = s.split(",");
    	return new EmployeeId(myString[1],Integer.parseInt(myString[0]));
    }
}