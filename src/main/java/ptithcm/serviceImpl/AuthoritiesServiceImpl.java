package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.AuthoritiesDao;
import ptithcm.entity.Authorities;

/**
 * @author Tuong
 */
public class AuthoritiesServiceImpl implements ptithcm.service.AuthoritiesService {

    @Autowired
    AuthoritiesDao authoritiesDao;

    @Override
    public String addAuthorities(Authorities authorities) {
        return authoritiesDao.save(authorities);
    }

    @Override
    public Authorities findAuthoritiesByusername(String username) {
        return authoritiesDao.findOne(username);
    }

    @Override
    public String getRole(String username) {
        Authorities auth = authoritiesDao.findOne(username);
        if (auth != null) {
            return authoritiesDao.findOne(username).getAuthorityType();
        } else {
            return "";
        }
    }
}
