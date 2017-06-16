package com.charity.channel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClient;

@Configuration
public class SQSConfig {

    @Value("${queue.endpoint}")
    private String endpoint;

    @Value("${queue.name}")
    private String queueName;
    


    @Bean
    public AmazonSQSClient createSQSClient() {

        AmazonSQSClient amazonSQSClient = new AmazonSQSClient(new BasicAWSCredentials("",""));
        amazonSQSClient.setEndpoint(endpoint);
        amazonSQSClient.createQueue(queueName);
        return amazonSQSClient;
}

    // for AWS uncomment below code and comment above method
    
    /*@SuppressWarnings("deprecation")
	@Bean
    public AmazonSQSClient createSQSClient() {
    	
    	String accessKeyId = "AKIAINBIYHB46G4G3C7Q";
    	String secretAccessKey = "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";
        BasicAWSCredentials credentials = null;
		try 
		{
			credentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
		} 
		catch (Exception e) 
		{
			throw new AmazonClientException("Cannot load the credentials from the credential profiles file.", e);
		}
		AmazonSQSClient amazonSQSClient = new AmazonSQSClient(credentials);
		Region euWest1 = Region.getRegion(Regions.AP_SOUTHEAST_1);
		amazonSQSClient.setRegion(euWest1);
		 amazonSQSClient.setEndpoint(endpoint);
        amazonSQSClient.createQueue(queueName);
        return amazonSQSClient;
    }*/

}
