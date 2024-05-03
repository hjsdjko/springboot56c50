package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShangpinzujieEntity;
import com.entity.view.ShangpinzujieView;

import com.service.ShangpinzujieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 商品租借
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-23 17:06:02
 */
@RestController
@RequestMapping("/shangpinzujie")
public class ShangpinzujieController {
    @Autowired
    private ShangpinzujieService shangpinzujieService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpinzujieEntity shangpinzujie, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			shangpinzujie.setMaijiahao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			shangpinzujie.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShangpinzujieEntity> ew = new EntityWrapper<ShangpinzujieEntity>();
		PageUtils page = shangpinzujieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinzujie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangpinzujieEntity shangpinzujie, HttpServletRequest request){
        EntityWrapper<ShangpinzujieEntity> ew = new EntityWrapper<ShangpinzujieEntity>();
		PageUtils page = shangpinzujieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinzujie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangpinzujieEntity shangpinzujie){
       	EntityWrapper<ShangpinzujieEntity> ew = new EntityWrapper<ShangpinzujieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpinzujie, "shangpinzujie")); 
        return R.ok().put("data", shangpinzujieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangpinzujieEntity shangpinzujie){
        EntityWrapper< ShangpinzujieEntity> ew = new EntityWrapper< ShangpinzujieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpinzujie, "shangpinzujie")); 
		ShangpinzujieView shangpinzujieView =  shangpinzujieService.selectView(ew);
		return R.ok("查询商品租借成功").put("data", shangpinzujieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpinzujieEntity shangpinzujie = shangpinzujieService.selectById(id);
        return R.ok().put("data", shangpinzujie);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpinzujieEntity shangpinzujie = shangpinzujieService.selectById(id);
        return R.ok().put("data", shangpinzujie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinzujieEntity shangpinzujie, HttpServletRequest request){
    	shangpinzujie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinzujie);
        shangpinzujieService.insert(shangpinzujie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinzujieEntity shangpinzujie, HttpServletRequest request){
    	shangpinzujie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinzujie);
        shangpinzujieService.insert(shangpinzujie);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinzujieEntity shangpinzujie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinzujie);
        shangpinzujieService.updateById(shangpinzujie);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangpinzujieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ShangpinzujieEntity> wrapper = new EntityWrapper<ShangpinzujieEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			wrapper.eq("maijiahao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = shangpinzujieService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
