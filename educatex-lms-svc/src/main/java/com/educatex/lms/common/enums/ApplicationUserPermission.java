package com.educatex.lms.common.enums;


public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("cpirse:read"),
    COURSE_WRITE("course:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");


    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
