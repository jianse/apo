package cn.ntboy.service.impl;

import cn.ntboy.model.Menus;
import cn.ntboy.model.MenusExample;
import cn.ntboy.model.combination.MenusAndTypes;
import cn.ntboy.model.vo.PageVO;
import cn.ntboy.repository.MenusMapper;
import cn.ntboy.repository.MenusMapperCustom;
import cn.ntboy.service.MenuService;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.util.InjectMapper;
import cn.ntboy.util.tx.Service;
import cn.ntboy.util.tx.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @InjectMapper
    public void setMenusMapper(MenusMapper menusMapper) {
        this.menusMapper = menusMapper;
    }

    @InjectMapper
    public void setMenusMapperCustom(MenusMapperCustom menusMapperCustom) {
        this.menusMapperCustom = menusMapperCustom;
    }

    private MenusMapperCustom menusMapperCustom =null;
    private MenusMapper menusMapper = null;

    @Override
    public ServiceResultState<PageVO<Menus>> getAllMenus(PageVO page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        MenusExample example = new MenusExample();
        example.createCriteria().andIdIsNotNull();
        List<Menus> menus = menusMapper.selectByExample(example);

        PageInfo<Menus> pageInfo = PageInfo.of(menus);

        PageVO<Menus> pageVO = new PageVO<>();

        try {
            BeanUtils.copyProperties(pageVO,pageInfo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("copy properties error",e);
//            e.printStackTrace();
        }

        pageVO.setTotal(pageInfo.getTotal());

        pageVO.setData(menus);

        return ServiceResultState.wrap(200,pageVO);
    }

    @Override
    public ServiceResultState<PageVO<MenusAndTypes>> getAllMenusWithType(PageVO page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<MenusAndTypes> menus = menusMapperCustom.selectAllMenusAndTypes();

        PageInfo<MenusAndTypes> pageInfo = PageInfo.of(menus);

        PageVO<MenusAndTypes> pageVO = new PageVO<>();

        try {
            BeanUtils.copyProperties(pageVO,pageInfo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("copy properties error",e);
//            e.printStackTrace();
        }

        pageVO.setTotal(pageInfo.getTotal());

        pageVO.setData(menus);

        return ServiceResultState.wrap(200,pageVO);

    }

    @Transactional
    @Override
    public ServiceResultState deleteById(Integer id) {
        menusMapper.deleteByPrimaryKey(id);
        return ServiceResultState.wrap(200,null);
    }

    @Override
    public ServiceResultState<Menus> getById(Integer id) {
        Menus menus = menusMapper.selectByPrimaryKey(id);

        return ServiceResultState.wrap(menus==null?500:200,menus);
    }

    @Override
    public ServiceResultState<Menus> updateMenuById(Integer id, Menus newMenu) {
        newMenu.setId(id);
        int i = menusMapper.updateByPrimaryKey(newMenu);
        Menus menus = menusMapper.selectByPrimaryKey(id);
        return ServiceResultState.wrap(200,menus);
    }

    @Override
    public ServiceResultState<Menus> newMenu(Menus newMenu) {
        int insert = menusMapperCustom.insertAndSelectKey(newMenu);

        return ServiceResultState.wrap(200,newMenu);
    }
}
