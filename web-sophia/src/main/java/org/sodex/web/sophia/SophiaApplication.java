package org.sodex.web.sophia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.sodex.web.common.repository")
@EntityScan(basePackages = "org.sodex.web.common.bean")
public class SophiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SophiaApplication.class, args);
    }

}
