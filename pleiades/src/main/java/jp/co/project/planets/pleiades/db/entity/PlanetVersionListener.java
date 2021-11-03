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
public class PlanetVersionListener implements EntityListener<PlanetVersion> {

    @Override
    public void preInsert(PlanetVersion entity, PreInsertContext<PlanetVersion> context) {
    }

    @Override
    public void preUpdate(PlanetVersion entity, PreUpdateContext<PlanetVersion> context) {
    }

    @Override
    public void preDelete(PlanetVersion entity, PreDeleteContext<PlanetVersion> context) {
    }

    @Override
    public void postInsert(PlanetVersion entity, PostInsertContext<PlanetVersion> context) {
    }

    @Override
    public void postUpdate(PlanetVersion entity, PostUpdateContext<PlanetVersion> context) {
    }

    @Override
    public void postDelete(PlanetVersion entity, PostDeleteContext<PlanetVersion> context) {
    }
}
