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
public class Oauth2RegisteredClientListener implements EntityListener<Oauth2RegisteredClient> {

    @Override
    public void preInsert(Oauth2RegisteredClient entity, PreInsertContext<Oauth2RegisteredClient> context) {
    }

    @Override
    public void preUpdate(Oauth2RegisteredClient entity, PreUpdateContext<Oauth2RegisteredClient> context) {
    }

    @Override
    public void preDelete(Oauth2RegisteredClient entity, PreDeleteContext<Oauth2RegisteredClient> context) {
    }

    @Override
    public void postInsert(Oauth2RegisteredClient entity, PostInsertContext<Oauth2RegisteredClient> context) {
    }

    @Override
    public void postUpdate(Oauth2RegisteredClient entity, PostUpdateContext<Oauth2RegisteredClient> context) {
    }

    @Override
    public void postDelete(Oauth2RegisteredClient entity, PostDeleteContext<Oauth2RegisteredClient> context) {
    }
}
