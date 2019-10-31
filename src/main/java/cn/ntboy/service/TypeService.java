package cn.ntboy.service;

import cn.ntboy.model.Types;

import java.util.List;

public interface TypeService {
    ServiceResultState<List<Types>> getAllTypes();

    ServiceResultState deleteById(Integer id);

    ServiceResultState<Types> newType(Types types);

    ServiceResultState<Types> getTypeById(Integer id);

    ServiceResultState<Types> updateById(Integer id, Types newType);
}
