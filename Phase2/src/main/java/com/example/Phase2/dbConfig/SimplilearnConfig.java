package com.example.Phase2.dbConfig;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SimplilearnConfig {
    public static SessionFactory getSessionFactory() {
        Configuration con = new Configuration();
        con.configure("META-INF/hibernate.cfg.xml");
        return con.buildSessionFactory();
    }
}
