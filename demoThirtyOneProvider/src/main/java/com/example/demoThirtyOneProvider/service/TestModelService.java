package com.example.demoThirtyOneProvider.service;

import com.example.demoThirtyOneProvider.mapper.TestModelMapper;
import com.example.demoThirtyOneProvider.model.TestModel;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestModelService {


    @Autowired
    private TestModelMapper testModelMapper;

    public Page<TestModel> findByIdGreaterThanWithPage(Integer minId, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return (Page<TestModel>) testModelMapper.findByIdGreaterThan(minId);
    }

}
