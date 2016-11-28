/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import model.User;

/**
 *
 * @author clevi
 */
public interface ILogin {
    public User login(String nickname,String password) throws SQLException;
}
