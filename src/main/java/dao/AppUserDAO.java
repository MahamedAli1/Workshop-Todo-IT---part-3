package dao;

import Model.AppUser;

import java.util.Collection;

public interface AppUserDAO {
    void persist(AppUser user);
    AppUser findByUsername(String username);
    Collection<AppUser> findAll();
    void remove(AppUser user);
}
