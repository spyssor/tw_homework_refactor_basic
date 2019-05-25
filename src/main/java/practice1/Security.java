package practice1;

import com.google.common.collect.ImmutableList;

public class Security {

    private SecurityChecker securityChecker;

    public Security(SecurityChecker checker) {
        this.securityChecker = checker;
    }

    public boolean hasAccess(User user, Permission permission, ImmutableList<Permission> permissions) {

        if (isNullUser(user)) {
            return prohibit();
        }

        if (isNullPermission(permission)) {
            return prohibit();
        }

        if (isEmptyPermissions(permissions)) {
            return prohibit();
        }

        if (isAdmin()) {
            return access();
        }

        if (isValidPermission(user, permission, permissions)) {
            return access();
        }

        return prohibit();
    }

    private boolean isNullUser(User user){
        return user == null;
    }

    private boolean isNullPermission(Permission permission) {
        return permission == null;
    }

    private boolean isEmptyPermissions(ImmutableList<Permission> permissions) {
        return permissions.size() == 0;
    }

    private boolean isAdmin(){
        return securityChecker.isAdmin();
    }

    private boolean isValidPermission(User user, Permission permission, ImmutableList<Permission> permissions){
        return securityChecker.checkPermission(user, permission) || permissions.contains(permission);
    }

    private boolean access(){
        return true;
    }

    private boolean prohibit(){
        return false;
    }
}
