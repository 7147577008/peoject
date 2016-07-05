package com.it.dao;

import com.it.entity.Docoment;
import com.it.util.DbHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
public class DocumenDao {


    public void save(Docoment docoment) {
        String sql = "insert   into  t_document(filename,savename,md5,extname,size,displaysize)values(?,?,?,?,?,?)";
        DbHelp.updata(sql, docoment.getFilename(), docoment.getSavename(), docoment.getMd5(), docoment.getExtname(), docoment.getSize(), docoment.getDisplaysize());
    }

    public Docoment findmd5(String md5) {
        String sql = "select * from t_document where md5=?";
        return DbHelp.query(sql, new BeanHandler<>(Docoment.class), md5);
    }

    public List<Docoment> findAll() {
        String sql = "select * from t_document order by id desc";
        return DbHelp.query(sql, new BeanListHandler<>(Docoment.class));
    }
}
