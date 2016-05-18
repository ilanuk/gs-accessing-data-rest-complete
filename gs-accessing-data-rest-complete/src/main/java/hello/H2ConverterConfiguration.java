package hello;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.DefaultFormattingConversionService;

@EnableAutoConfiguration
@Configuration
public class H2ConverterConfiguration {

    @Resource(name = "defaultConversionService")
    private DefaultFormattingConversionService defaultConversionService;

    @Bean
    public String2EmployeeIdConverter string2EmployeeIdConverter(){
    	String2EmployeeIdConverter string2EmployeeIdConverter = new String2EmployeeIdConverter();
        defaultConversionService.addConverter(string2EmployeeIdConverter);
        return string2EmployeeIdConverter;
    }

    @Bean
    public String2EmployeeIdIntegerConverter string2EmployeeIdIntegerConverter(){
    	String2EmployeeIdIntegerConverter string2EmployeeIdIntegerConverter = new String2EmployeeIdIntegerConverter();
        defaultConversionService.addConverter(string2EmployeeIdIntegerConverter);
        return string2EmployeeIdIntegerConverter;
    }
}