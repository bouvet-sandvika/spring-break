package no.sandvika.springbreak;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MyMongoDBConfiguration extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.username}")
    private String username;


    @Override
    public MongoClient mongoClient() {
        String uri = String.format("mongodb+srv://%s:%s@spring-break-xciwv.mongodb.net/test?retryWrites=true&w=majority", username, password);
        return new MongoClient(new MongoClientURI(uri));
    }

    @Override
    protected String getDatabaseName() {
        return "kes";
    }
}



