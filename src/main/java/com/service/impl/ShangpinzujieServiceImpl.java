package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShangpinzujieDao;
import com.entity.ShangpinzujieEntity;
import com.service.ShangpinzujieService;
import com.entity.vo.ShangpinzujieVO;
import com.entity.view.ShangpinzujieView;

@Service("shangpinzujieService")
public class ShangpinzujieServiceImpl extends ServiceImpl<ShangpinzujieDao, ShangpinzujieEntity> implements ShangpinzujieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangpinzujieEntity> page = this.selectPage(
                new Query<ShangpinzujieEntity>(params).getPage(),
                new EntityWrapper<ShangpinzujieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangpinzujieEntity> wrapper) {
		  Page<ShangpinzujieView> page =new Query<ShangpinzujieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangpinzujieVO> selectListVO(Wrapper<ShangpinzujieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangpinzujieVO selectVO(Wrapper<ShangpinzujieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangpinzujieView> selectListView(Wrapper<ShangpinzujieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangpinzujieView selectView(Wrapper<ShangpinzujieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
