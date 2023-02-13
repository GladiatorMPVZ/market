package rest.Services;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(JwtProperties.PREFIX)
@Data
public class JwtProperties {

    public static  final String PREFIX = "jwt";

    private String secret;

    private Long expireTime;
}
