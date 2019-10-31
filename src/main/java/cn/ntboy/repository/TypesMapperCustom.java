package cn.ntboy.repository;

import cn.ntboy.model.Types;

public interface TypesMapperCustom {

    /**
     * 插入新Type 并查询自增主键
     * @param types 要插入的Types
     * @return 受影响的行数
     */
    Integer insertSelectKey(Types types);
}
