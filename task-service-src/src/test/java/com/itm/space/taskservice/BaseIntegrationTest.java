package com.itm.space.taskservice;

import com.github.database.rider.spring.api.DBRider;
import com.itm.space.taskservice.initializer.KafkaInitializer;
import com.itm.space.taskservice.initializer.PostgresInitializer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;



@ContextConfiguration(initializers = {PostgresInitializer.class, KafkaInitializer.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DBRider
@AutoConfigureMockMvc
public abstract class BaseIntegrationTest {

}