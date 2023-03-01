package dao;

import com.example.Phase2.dbConfig.SimplilearnConfig;
import com.example.Phase2.entity.Login;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LoginDao {

    private SessionFactory sessionFactory;

    public LoginDao() {
        sessionFactory = SimplilearnConfig.getSessionFactory();
    }

    public List<Login> getLoginFromEmail(String email){
        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "SELECT * FROM Login WHERE email = :email";
        Query<Login> query = session.createNativeQuery(sql, Login.class);
        query.setParameter("email", email);

        List<Login> logins = query.getResultList();

        transaction.commit();
        session.close();

        return logins;
    }
}
