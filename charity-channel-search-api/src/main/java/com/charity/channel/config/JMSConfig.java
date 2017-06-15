package com.charity.channel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

@Configuration
public class JMSConfig {

    @Value("${queue.endpoint}")
    private String endpoint;

    @Value("${queue.name}")
    private String queueName;
    
    String accessKey = "AKIAINBIYHB46G4G3C7Q";
	
	String secretAccessKey = "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";


    @Bean
    public JmsTemplate createJMSTemplate() 
    {

        SQSConnectionFactory sqsConnectionFactory = SQSConnectionFactory.builder()
                .withAWSCredentialsProvider(awsCredentialsProvider)
                .withEndpoint(endpoint)
                .withNumberOfMessagesToPrefetch(10).build();

        JmsTemplate jmsTemplate = new JmsTemplate(sqsConnectionFactory);
        jmsTemplate.setDefaultDestinationName(queueName);
        jmsTemplate.setDeliveryPersistent(false);


        return jmsTemplate;
    }
    
    @Bean
    public AWSCredentials awsCredentials() {
        return new BasicAWSCredentials(accessKey, secretAccessKey);
    }

    
    /**
     * AWS Connection Factory
     */
    /*@Bean
    public SQSConnectionFactory connectionFactory() {
        SQSConnectionFactory.Builder factoryBuilder = new SQSConnectionFactory
        														.Builder(Region.getRegion(Regions.AP_SOUTH_1)).withNumberOfMessagesToPrefetch(10);
        factoryBuilder.setAwsCredentialsProvider(new AWSCredentialsProvider() {
														            @Override
														            public AWSCredentials getCredentials() {
														                return awsCredentials();
														            }
														
														            @Override
														            public void refresh() {
														            }

        });
        return factoryBuilder.build();
    }*/



    private final AWSCredentialsProvider awsCredentialsProvider = new AWSCredentialsProvider() {
        public AWSCredentials getCredentials() {
            return new BasicAWSCredentials("", "");
        }

        public void refresh() {

        }
    };

}
