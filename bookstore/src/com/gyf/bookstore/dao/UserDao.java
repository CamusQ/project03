package com.gyf.bookstore.dao;

import com.gyf.bookstore.model.User;
import com.gyf.bookstore.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    /**
     * 添加一个用户
     */
    public void addUser(User user) throws SQLException {

        //1.获取QueryRunner
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        //2.sql语句
        String sql = "insert into user(username,PASSWORD,gender,email,telephone,introduce,activeCode," +
                "state,role,registTime) values(?,?,?,?,?,?,?,?,?,?)";
        //3.参数
        List<Object> list = new ArrayList<Object>();
        list.add(user.getUsername());
        list.add(user.getPassword());
        list.add(user.getGender());
        list.add(user.getEmail());
        list.add(user.getTelephone());
        list.add(user.getIntroduce());
        list.add(user.getActiveCode());
        list.add(user.getState());
        list.add(user.getRole());
        list.add(user.getRegistTime());

        //4.执行sql
        qr.update(sql, list.toArray());
    }
}
