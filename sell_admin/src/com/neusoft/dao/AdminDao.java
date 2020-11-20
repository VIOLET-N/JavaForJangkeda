package com.neusoft.dao;

import com.neusoft.domain.Admin;
import com.sun.jdi.event.StepEvent;

public interface AdminDao {
    public Admin getAdminByNameAndPassword(String Admin,String password);
}
