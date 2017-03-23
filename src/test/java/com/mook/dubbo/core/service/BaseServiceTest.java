package com.mook.dubbo.core.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/conf/spring.xml", "/conf/dubbo-provider.xml"})
public class BaseServiceTest {}
