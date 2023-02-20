package com.spring5.demo.dao.impl;

import com.spring5.demo.dao.BookDao;
import com.spring5.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.*;
import java.util.stream.Collectors;

/**
 * com.spring5.demo.dao.impl
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 21:31
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void insert(Book book) {
        String sql = "insert into spring_book (name, age) values ('" + book.getName() + "', " + book.getAge() + ")";
        jdbcTemplate.execute(sql);
        String extraSql = "insert into spring_book (name, age) values (?, ?)";
        Object[] values = {book.getName(), book.getAge()};
        int insert = jdbcTemplate.update(extraSql, values);
        System.out.println("insert = " + insert);
    }

    @Override
    public void update(Book book) {
        String sql = "update spring_book set age = ? where id = ?";
        int update = jdbcTemplate.update(sql, book.getAge(), book.getId());
        System.out.println("update = " + update);
        System.out.println("TransactionSynchronizationManager.getCurrentTransactionName() = " + TransactionSynchronizationManager.getCurrentTransactionName());
    }

    @Override
    public Integer total() {
        String sql = "select count(*) from spring_book";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Book fetchOne(Integer id) {
        String sql = "select * from spring_book where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    @Override
    public List<Book> fetch(List<Integer> id) {
        HashMap<String, Object> maps = new HashMap<>();
        maps.put("ids", id);
        String sql = "select * from spring_book where id in (:ids)";
        return namedParameterJdbcTemplate.queryForList(sql, maps, Book.class);
    }

    @Override
    public void del(Integer id) {
        String sql = "delete from spring_book where id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println("del = " + update);
    }

    @Override
    public void batchInsert(List<Book> book) {
        String sql = "insert into spring_book (name, age) values (?, ?)";
        List<Object[]> rows = book.stream().map(s -> {
            Object[] arr = new Object[2];
            arr[0] = s.getName();
            arr[1] = s.getAge();
            return arr;
        }).collect(Collectors.toList());
        int[] ints = jdbcTemplate.batchUpdate(sql, rows);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    @Override
    public void batchUpdate(List<Book> book) {
        String sql = "update spring_book set age = ? where id = ?";
        List<Object[]> rows = book.stream().map(s -> {
            Object[] arr = new Object[2];
            arr[0] = s.getAge();
            arr[1] = s.getId();
            return arr;
        }).collect(Collectors.toList());
        int[] ints = jdbcTemplate.batchUpdate(sql, rows);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    @Override
    public void batchDel(List<Book> book) {
        List<Object[]> rows = book.stream().map(s -> {
            Object[] arr = new Object[1];
            arr[0] = s.getId();
            return arr;
        }).collect(Collectors.toList());
        String sql = "delete from spring_book where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, rows);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
