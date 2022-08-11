//package com.fwk.flowabledemo;
//
//import com.mysql.cj.jdbc.Driver;
//
//import java.sql.*;
//
//public class Test {
//
//    @org.junit.jupiter.api.Test
//    public void t1() throws ClassNotFoundException, SQLException {
//        //注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        //获取连接
//        String url = "jdbc:mysql://114.116.9.97:3306/fwkdb?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true";
//        Connection connection = DriverManager.getConnection(url, "root", "1qw2!QW@");
//        Statement statement = connection.createStatement();
////        statement.execute("alter table mytable add name varchar (64)");
////        System.out.println("statement.execute(\"create table mytable\") = " + statement.execute("create table mytable(id varchar (32))"));
////        System.out.println("insert " + statement.execute("insert into mytable values (" + System.currentTimeMillis()+ ")"));
//        ResultSet resultSet = statement.executeQuery("select * from mytable ");
//        while (resultSet.next()){
//            MyTable myTable = new MyTable();
//            myTable.setId(resultSet.getString("id"));
//            myTable.setName(resultSet.getString("name"));
//            System.out.println(myTable.toString());
//
//        }
//        resultSet.close();
//        statement.close();
//        connection.close();
//
//
//    }
//
//
//    public class MyTable{
//
//        private String id;
//        private String name;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public String toString() {
//            return "MyTable{" +
//                    "id='" + id + '\'' +
//                    ", name='" + name + '\'' +
//                    '}';
//        }
//    }
//
//
//
//}
