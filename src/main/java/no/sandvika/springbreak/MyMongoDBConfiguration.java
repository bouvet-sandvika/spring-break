package no.sandvika.springbreak;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MyMongoDBConfiguration extends AbstractMongoConfiguration {
    @Override
    public MongoClient mongoClient() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://spring-user:<password>@spring-break-xciwv.mongodb.net/test?retryWrites=true&w=majority");

        return new MongoClient(uri);
    }

    @Override
    protected String getDatabaseName() {
        return "kes";
    }
}



