package Config;

import Beans.Client;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import java.text.DateFormat;
import java.util.Date;

@Configuration
@PropertySource("client.properties")
public class SprConfig {

    @Autowired
    private Environment environment;

    @Bean public Date getDate(){
        return new Date();
    }
    @Bean public DateFormat dateFormat(){
        return DateFormat.getDateTimeInstance();
    }
    @Bean public Client client(){
        Client client = new Client();
        ((Client) client).setID(Integer.parseInt(environment.getRequiredProperty("id")));
        ((Client) client).setGreeting(environment.getRequiredProperty("greeting"));
        ((Client) client).setName(environment.getRequiredProperty("name"));
        return client;
    }

}
