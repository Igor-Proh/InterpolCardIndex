package com.prokhnov.interpolCardIndex.configuration;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.spring.api.DBRider;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DBRider
@DBUnit(url = "jdbc:h2:mem:default;DB_CLOSE_DELAY=-1")
public abstract class UnitTestConfiguration {
}
