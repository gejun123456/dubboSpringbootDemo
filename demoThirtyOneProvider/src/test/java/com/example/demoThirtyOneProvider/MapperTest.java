package com.example.demoThirtyOneProvider;

import com.example.demoThirtyOneProvider.model.TestModel;
import com.example.demoThirtyOneProvider.mapper.TestModelMapper;
import com.example.demoThirtyOneProvider.service.TestModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import org.assertj.core.api.Assertions;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private TestModelMapper testModelMapper;

    @Autowired
    private TestModelService testModelService;
    @Test
    public void testMapper(){
        TestModel testModel = new TestModel();
        testModel.setAge(1);
        testModel.setCreatedAt(new Date());
        testModel.setUpdatedAt(new Date());
        testModel.setUserName("lalal");
        testModelMapper.insert(testModel);
    }

    @Test
    public void testMapperWithPage(){
        for (int i = 0; i < 100; i++) {
            TestModel testModel = new TestModel();
            testModel.setAge(1);
            testModel.setCreatedAt(new Date());
            testModel.setUpdatedAt(new Date());
            testModel.setUserName("lalal");
            testModelMapper.insert(testModel);
        }

        Page<TestModel> byIdGreaterThanWithPage = testModelService.findByIdGreaterThanWithPage(0, 1, 20);
        Assertions.assertThat(byIdGreaterThanWithPage.getPageSize()).isGreaterThanOrEqualTo(5);
        Assertions.assertThat(byIdGreaterThanWithPage.size()).isEqualTo(20);
    }
}