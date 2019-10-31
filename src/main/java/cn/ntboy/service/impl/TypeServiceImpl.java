package cn.ntboy.service.impl;

import cn.ntboy.model.Types;
import cn.ntboy.model.TypesExample;
import cn.ntboy.repository.TypesMapper;
import cn.ntboy.repository.TypesMapperCustom;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.service.TypeService;
import cn.ntboy.util.InjectMapper;
import cn.ntboy.util.tx.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @InjectMapper
    public void setTypesMapper(TypesMapper typesMapper) {
        this.typesMapper = typesMapper;
    }

    private TypesMapper typesMapper = null;


    private TypesMapperCustom typesMapperCustom = null;

    @Override
    public ServiceResultState<List<Types>> getAllTypes() {
        TypesExample example = new TypesExample();
        example.createCriteria().andIdIsNotNull();
        List<Types> types = typesMapper.selectByExample(example);
        return ServiceResultState.wrap(200,types);
    }

    @Override
    public ServiceResultState deleteById(Integer id) {
        typesMapper.deleteByPrimaryKey(id);
        return ServiceResultState.wrap(200,null);
    }

    @Override
    public ServiceResultState<Types> newType(Types types) {
        Integer integer = typesMapperCustom.insertSelectKey(types);
        return ServiceResultState.wrap(200,types);
    }

    @Override
    public ServiceResultState<Types> getTypeById(Integer id) {
        return ServiceResultState.wrap(200,typesMapper.selectByPrimaryKey(id));
    }

    @Override
    public ServiceResultState<Types> updateById(Integer id, Types newType) {
        newType.setId(id);
        int i = typesMapper.updateByPrimaryKey(newType);
        return ServiceResultState.wrap(200,newType);
    }

    @InjectMapper
    public void setTypesMapperCustom(TypesMapperCustom typesMapperCustom) {
        this.typesMapperCustom = typesMapperCustom;
    }
}
