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
public class PlanetsVersionListener implements EntityListener<PlanetsVersion> {

    @Override
    public void preInsert(PlanetsVersion entity, PreInsertContext<PlanetsVersion> context) {
    }

    @Override
    public void preUpdate(PlanetsVersion entity, PreUpdateContext<PlanetsVersion> context) {
    }

    @Override
    public void preDelete(PlanetsVersion entity, PreDeleteContext<PlanetsVersion> context) {
    }

    @Override
    public void postInsert(PlanetsVersion entity, PostInsertContext<PlanetsVersion> context) {
    }

    @Override
    public void postUpdate(PlanetsVersion entity, PostUpdateContext<PlanetsVersion> context) {
    }

    @Override
    public void postDelete(PlanetsVersion entity, PostDeleteContext<PlanetsVersion> context) {
    }
}
