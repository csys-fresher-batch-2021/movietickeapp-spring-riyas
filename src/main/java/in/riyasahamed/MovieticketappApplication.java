/*
 * FileName: MovieticketappApplication.java
 * Author  : riya2641
 * 
 * Using JRE 17.0.4.1
 * 
 * Copyright(c) 2024 Chain-Sys Corporation Inc.
 * Duplication or distribution of this code in part or in whole by any media
 * without the express written permission of Chain-Sys Corporation or its agents is
 * strictly prohibited.
 * 
 * REVISION         DATE            NAME     DESCRIPTION
 * 511.101       04-Jan-2024       Riyas Ahamed   Initial Code
 */
package in.riyasahamed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableSwagger2
@SpringBootApplication
public class MovieticketappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieticketappApplication.class, args);
    }

}
