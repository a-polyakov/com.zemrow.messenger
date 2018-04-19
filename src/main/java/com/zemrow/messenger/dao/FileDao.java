package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.File;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с файлами
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class FileDao extends AbstractDaoCreateAndDelete<File> {

    public FileDao(Ignite ignite) {
        super(ignite, File.class, 2);
    }
}