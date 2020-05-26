/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Shariar
 */
public class DataSource {

    private static final DataSource DS = new DataSource();
    
    private DataSource() {
    }

    /**
     * Only use one connection for this application, prevent memory leaks.
     */
    private Connection createConnection() {

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup("jdbc/books");
            return ds.getConnection();
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Connection get(){
        return DS.createConnection();
    }
}
