package com.university.dao;

import com.university.model.Role;

import java.util.List;
import java.util.Set;

/**
 * Created by volodymyrO on 25.03.16.
 */
public interface RoleDao {

    public Role getRoleById(int id);

    public Role getRoleByName(Role.Name name);

    List<Role> getRolesByIds(Set<Integer> roleIds);

    public int saveRole(Role Role);

    public List<Role> getAllRoles();

    public void updateRole(Role Role);

    public void deleteRole(Role Role);
}
