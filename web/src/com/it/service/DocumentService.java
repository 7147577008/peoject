package com.it.service;


import com.it.dao.DocumenDao;
import com.it.entity.Docoment;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/6/16.
 */
public class DocumentService {
    private Logger logger = LoggerFactory.getLogger(DocumentService.class);
    private DocumenDao documenDao = new DocumenDao();

    public void updateFile(String fileName, Long size, InputStream inputStream) throws Exception {
        ByteArrayInputStream byteArrayInputStream =
                new ByteArrayInputStream(IOUtils.toByteArray(inputStream));


        String md5 = DigestUtils.md5Hex(byteArrayInputStream);
        logger.debug("MD5:{}", md5);

        Docoment docoment = documenDao.findmd5(md5);
        if (docoment == null) {

            String saveFileName = saveFile(fileName, byteArrayInputStream);
            docoment = new Docoment();
            docoment.setFilename(fileName);
            docoment.setSavename(saveFileName);
            docoment.setExtname(fileName.substring(fileName.indexOf(".")));
            docoment.setMd5(md5);
            docoment.setSize(size);
            docoment.setDisplaysize(FileUtils.byteCountToDisplaySize(size));

            documenDao.save(docoment);
        }
    }


    private String saveFile(String fileName, InputStream inputStream) throws Exception {
        inputStream.reset();
        File file = new File("D:/upload1");
        if (!file.exists()) {
            file.mkdir();
        }

        String exName = fileName.substring(fileName.indexOf("."));
        String uuid = UUID.randomUUID().toString();
        fileName = uuid + exName;

        FileOutputStream outputStream = new FileOutputStream(new File(file/*写到文件的根目录*/, fileName));
        IOUtils.copy(inputStream, outputStream);


        outputStream.flush();
        outputStream.close();
        inputStream.close();
        return fileName;
    }

    public List<Docoment> finAll() {
        return documenDao.findAll();
    }

    public Docoment findMd5(String md5) {
        return documenDao.findmd5(md5);
    }
}


