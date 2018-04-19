package com.zemrow.messenger.dao;

import com.zemrow.messenger.entity.Tag;
import org.apache.ignite.Ignite;

/**
 * DAO (data access object) для работы с тегами
 *
 * @author Alexandr Polyakov on 2018.04.15
 */
public class TagDao extends AbstractDao<Tag> {

    public TagDao(Ignite ignite) {
        super(ignite, Tag.class, 2);
    }
}