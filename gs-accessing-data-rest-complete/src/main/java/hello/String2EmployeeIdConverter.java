package hello;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class String2EmployeeIdConverter implements Converter<String, EmployeeId>{
    private static final Log LOGGER =  LogFactory.getLog(String2EmployeeIdConverter.class.getName());

    @Override
    public EmployeeId convert(String s) {
    	String[] input = s.split(",");
    	return new EmployeeId(input[1].split("=")[1],Integer.parseInt(input[0].split("=")[1]));
    }
}