package com.yuanziren.mapper;


import com.yuanziren.dto.UserDto;
import com.yuanziren.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {

    private UserMapper userMapper;
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;

    @Before
    public void init() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        session = sqlSessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    /**
     * 主外键一对一映射
     * @throws Exception
     */
    @Test
    public void queryUserByName() throws Exception {
        List<UserDto> userDtoList = userMapper.queryUserCard();
        userDtoList.stream().forEach(System.out::println);
    }

    /**
     * 主外键一对多映射
     * @throws Exception
     */
    @Test
    public void queryUserCardAccount() throws Exception {
        List<UserDto> userDtoList = userMapper.queryUserCardAccount();
        userDtoList.stream().forEach(System.out::println);
    }

    @Test
    public void test01() throws Exception {
        User u1 = new User();
        User u2 = new User();
        System.out.println(u1==u2);//false
    }

    @Test
    public void queryUserByName2() throws Exception {
        List<UserDto> userDtoList = userMapper.queryUserCard();
        userMapper.updateUser(114);
        List<UserDto> userDtoList2 = userMapper.queryUserCard();
        session.clearCache();// 清空缓存
        List<UserDto> userDtoList3 = userMapper.queryUserCard();


    }

    @Test
    public void queryUserByName3() throws Exception {
        List<UserDto> userDtoList = userMapper.queryUserCard();
        List<UserDto> userDtoList2 = userMapper.queryUserCard();
        session.close();


        session = sqlSessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
        List<UserDto> userDtoList3 = userMapper.queryUserCard();
    }


}