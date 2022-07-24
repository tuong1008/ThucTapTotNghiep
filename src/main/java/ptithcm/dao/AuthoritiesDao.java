package ptithcm.dao;

import ptithcm.entity.Authorities;

/**
 * @author Tuong
 */
public interface AuthoritiesDao extends GenericDao<Authorities> {
    Authorities findOne(String username);
}
