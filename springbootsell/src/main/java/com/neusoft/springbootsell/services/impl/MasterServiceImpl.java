package com.neusoft.springbootsell.services.impl;


import com.neusoft.springbootsell.dataobject.OrderMaster;
import com.neusoft.springbootsell.repository.OrderMasterRepository;
import com.neusoft.springbootsell.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {
    @Autowired
    OrderMasterRepository repository;

    @Override
    public List<OrderMaster> findAll() {
        return repository.findAll();
    }
}
