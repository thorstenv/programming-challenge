package de.exxcellent.challenge.elaborate.repository;

import de.exxcellent.challenge.elaborate.model.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@infoscreen.de>}
 * 04.02.2019
 *
 */
public class EntityRepository {
    
    private final List<Entity> db;
    
    public EntityRepository() {
        db = new ArrayList<>();
    }
    
    public void addEntity( Entity e ) {
        this.db.add(e);
    }
    
    public void addAllEntities( Collection<Entity> entities ) {
        this.db.addAll(entities);
    }
    
    public Entity getEntity( int index ) {
        try {
            return db.get(index);
        } catch(IndexOutOfBoundsException ex ) {
            return null;
        }
    }
    
    public List<Entity> findAll() {
        return db;
    }
}
