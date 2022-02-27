

package Dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConectarDB {
    public DriverManagerDataSource conDB(){
        DriverManagerDataSource dtasource = new DriverManagerDataSource();
        dtasource.setDriverClassName("com.mysql.jdbc.Driver");
        dtasource.setUrl("jdbc:mysql://localhost:3306/petlove");
        dtasource.setUsername("root");
        dtasource.setPassword("");
        return dtasource;
    }
}
