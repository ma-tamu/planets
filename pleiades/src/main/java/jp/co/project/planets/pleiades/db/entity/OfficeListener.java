package jp.co.project.planets.pleiades.db.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class OfficeListener implements EntityListener<Office> {

    @Override
    public void preInsert(Office entity, PreInsertContext<Office> context) {
    }

    @Override
    public void preUpdate(Office entity, PreUpdateContext<Office> context) {
    }

    @Override
    public void preDelete(Office entity, PreDeleteContext<Office> context) {
    }

    @Override
    public void postInsert(Office entity, PostInsertContext<Office> context) {
    }

    @Override
    public void postUpdate(Office entity, PostUpdateContext<Office> context) {
    }

    @Override
    public void postDelete(Office entity, PostDeleteContext<Office> context) {
    }
}
