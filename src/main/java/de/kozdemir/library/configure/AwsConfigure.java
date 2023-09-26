package de.kozdemir.library.configure;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Configuration
public class AwsConfigure {
    public static final String REGION="eu-west-3";
    public static final String ACCES_KEY="XXXXXXX";
    public static final String SECRET_KEY="XXXXXXX";

    @Bean
    public AmazonS3 s3Client(){
        return AmazonS3ClientBuilder.standard()
                .withRegion(REGION)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCES_KEY,SECRET_KEY)))
                .build();
    }

}
