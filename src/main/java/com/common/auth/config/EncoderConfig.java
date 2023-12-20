package com.common.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <b><code>EncoderConfig</code></b>
 * <p/>
 * EncoderConfig
 * <p/>
 * <b>Creation Time:</b> 2023/12/20 23:03
 *
 * @author yang xiong
 * @since CommonAuth 1.0
 */
@Configuration
public class EncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
