package ptithcm.service;

import ptithcm.entity.Authorities;

/**
 * @author Tuong
 */
public interface AuthoritiesService {
    String addAuthorities(Authorities authorities);

    Authorities findAuthoritiesByusername(String username);

    String getRole(String username);
}
