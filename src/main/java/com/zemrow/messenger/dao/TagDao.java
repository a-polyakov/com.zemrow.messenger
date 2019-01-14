package com.zemrow.messenger.dao;

import com.zemrow.messenger.DataBase;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.abstracts.AbstractDao;
import com.zemrow.messenger.dao.constants.IdConstant;
import com.zemrow.messenger.entity.SimpleKey;
import com.zemrow.messenger.entity.Tag;

/**
 * DAO (data access object) для работы с тегами
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class TagDao extends AbstractDao<Tag> {

    public TagDao(DataBase dataBase) {
        super(dataBase, Tag.class, IdConstant.FIRST_ID_TAG, 2);
    }

    /**
     * Получить тег по идентификатору.
     *
     * @param id Идентификатор тега.
     * @return Тег.
     */
    public Tag select(Long id) {
        return super.select(new SimpleKey(id));
    }

    //TODO
    @Override
    protected void update(SessionStorage session, Tag entity) {
        super.update(session, entity);
    }
}
