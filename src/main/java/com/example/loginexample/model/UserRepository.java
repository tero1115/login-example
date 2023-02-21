package com.example.loginexample.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

        public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

        public User findByUsername(@Param("username") String username);

        public int insert(@Param("username") String username, @Param("password") String password,
                        @Param("email") String email);

        public List<User> findAll();

        public User findById(int id);

        public int updateById(@Param("id") Integer id,
                        @Param("username") String username,
                        @Param("password") String password,
                        @Param("email") String email);

        public int deleteById(int id);

}
