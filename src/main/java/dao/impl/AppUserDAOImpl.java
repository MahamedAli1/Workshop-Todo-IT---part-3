package dao.impl;

import Model.AppUser;
import dao.AppUserDAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AppUserDAOImpl implements AppUserDAO {
    private final Map<String, AppUser> appUserMap = new HashMap<>();

    @Override
    public void persist(AppUser user) {
        appUserMap.put(user.getUsername(), user);
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserMap.get(username);
    }

    @Override
    public Collection<AppUser> findAll() {
        return appUserMap.values();
    }

    @Override
    public void remove(AppUser user) {
        appUserMap.remove(user.getUsername());
    }
}
