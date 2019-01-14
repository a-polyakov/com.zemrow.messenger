package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDaoCreateAndDelete;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.File;
import com.zemrow.messenger.entity.SimpleKey;

/**
 * DAO (data access object) для работы с файлами
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class FileDao extends AbstractDaoCreateAndDelete<File> {

    public FileDao(DataBase dataBase) {
        super(dataBase, File.class, IdConstant.FIRST_ID_FILE, 2);
    }

    /**
     * Получить файл по идентификатору.
     *
     * @param id Идентификатор файла.
     * @return Файл.
     */
    protected File select(Long id) {
        return super.select(new SimpleKey(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void update(SessionStorage session, File entity) {
        super.update(session, entity);
    }
}
