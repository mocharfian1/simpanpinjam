package com.finance.simjam.configurations;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.finance.simjam.repositories")
public class AWS {
    @Bean
    public AmazonDynamoDB amazonDynamoDB(AWSCredentials awsCred, @Value("${aws.region}") String region) {
        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCred))
                .withRegion(region);
        return builder.build();
    }

    @Bean
    public AWSCredentials awsCredentials(@Value("${aws.accessKey}") String accesskey,
                                         @Value("${aws.secretKey}") String secretkey) {
        return new BasicAWSCredentials(accesskey, secretkey);
    }

}
