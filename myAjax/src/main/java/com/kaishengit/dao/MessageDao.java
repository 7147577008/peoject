package com.kaishengit.dao;

import com.kaishengit.entity.Message;
import com.kaishengit.util.DbHelp;
import com.kaishengit.util.cache.CacheUtil;
import net.sf.ehcache.management.CacheManager;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2016/6/24.
 */
public class MessageDao {
    Logger logger = LoggerFactory.getLogger(MessageDao.class);

    public Message finById(Integer id) {
        Message message = (Message) CacheUtil.get("message" + id);
        if (message == null) {
            String sql = "select * from t_message where id=?";
            message = DbHelp.query(sql, new BeanHandler<>(Message.class), id);
            CacheUtil.set("message" + id, message);
        } else {
            logger.debug("load message from cache");
        }
        return message;
    }


    public List<Message> findAll() {
        List<Message> messageList = (List<Message>) CacheUtil.get("messageList");
        if (messageList == null) {

            String sql = "select * from t_message order by id desc";
            messageList = DbHelp.query(sql, new BeanListHandler<>(Message.class));
            CacheUtil.set("messageList", messageList);
        }
        return messageList;
    }

    public void save(Message message) {
        String sql = "insert into t_message(name,message)values(?,?)";
        DbHelp.updata(sql, message.getName(), message.getMessage());
        CacheUtil.remove("messageList");
    }


    public List<Message> findMaxId(String maxid) {
        String sql = "select * from t_message where id >? order by id desc";
        return DbHelp.query(sql, new BeanListHandler<>(Message.class), maxid);
    }
}
