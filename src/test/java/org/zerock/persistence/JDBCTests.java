package org.zerock.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.fail;

@Log4j
public class JDBCTests {

    static {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {

        try(Connection con =
                    DriverManager.getConnection("jdbc:oracle:thin:@DB202202081147_medium?TNS_ADMIN=/Users/ijubin/Downloads/Wallet_DB202202081147/",
                            "ADMIN", "!@4kY@KU9GppDAE")){

            log.info(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}

