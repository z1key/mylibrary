package org.z1key.projects.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 21.01.2017.
 */
@Entity
@Table(name = "superusers")
public class Superuser extends User implements DomainObject {
    private static final long serialVersionUID = 1L;
    @Column
    private String description;

    @Column
    private boolean permissionAdd = false;

    @Column
    private boolean permissionDelete = false;

    @Column
    private boolean permissionEdit = false;

    @Column
    private boolean permissionTx = false;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPermissionAdd() {
        return permissionAdd;
    }

    public void setPermissionAdd(boolean permissionAdd) {
        this.permissionAdd = permissionAdd;
    }

    public boolean isPermissionDelete() {
        return permissionDelete;
    }

    public void setPermissionDelete(boolean permissionDelete) {
        this.permissionDelete = permissionDelete;
    }

    public boolean isPermissionEdit() {
        return permissionEdit;
    }

    public void setPermissionEdit(boolean permissionEdit) {
        this.permissionEdit = permissionEdit;
    }

    public boolean isPermissionTx() {
        return permissionTx;
    }

    public void setPermissionTx(boolean permissionTx) {
        this.permissionTx = permissionTx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Superuser)) return false;
        if (!super.equals(o)) return false;

        Superuser superuser = (Superuser) o;

        if (permissionAdd != superuser.permissionAdd) return false;
        if (permissionDelete != superuser.permissionDelete) return false;
        if (permissionEdit != superuser.permissionEdit) return false;
        if (permissionTx != superuser.permissionTx) return false;
        return description != null ? description.equals(superuser.description) : superuser.description == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (permissionAdd ? 1 : 0);
        result = 31 * result + (permissionDelete ? 1 : 0);
        result = 31 * result + (permissionEdit ? 1 : 0);
        result = 31 * result + (permissionTx ? 1 : 0);
        return result;
    }
}
