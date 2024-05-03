package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangpinzujieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangpinzujieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinzujieView;


/**
 * 商品租借
 *
 * @author 
 * @email 
 * @date 2021-02-23 17:06:02
 */
public interface ShangpinzujieService extends IService<ShangpinzujieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangpinzujieVO> selectListVO(Wrapper<ShangpinzujieEntity> wrapper);
   	
   	ShangpinzujieVO selectVO(@Param("ew") Wrapper<ShangpinzujieEntity> wrapper);
   	
   	List<ShangpinzujieView> selectListView(Wrapper<ShangpinzujieEntity> wrapper);
   	
   	ShangpinzujieView selectView(@Param("ew") Wrapper<ShangpinzujieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangpinzujieEntity> wrapper);
   	
}

