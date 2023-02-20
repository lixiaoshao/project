package com.honor.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.honor.mybatisplus.entity.Emp;
import com.honor.mybatisplus.service.EmpService;
import com.honor.mybatisplus.mapper.EmpMapper;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
implements EmpService{

}
