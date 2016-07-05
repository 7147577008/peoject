package com.kaishengit.service;

import com.kaishengit.dao.MessageDao;
import com.kaishengit.entity.Message;

import java.util.List;

/**
 * Created by Administrator on 2016/6/24.
 */
public class MessageService {

    private MessageDao dao = new MessageDao();

    public List<Message> findAll() {
        return dao.findAll();
    }

    public List<Message> findMessageMaxId(String maxid) {
        return dao.findMaxId(maxid);
    }
}
