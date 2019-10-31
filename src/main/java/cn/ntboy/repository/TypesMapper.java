package cn.ntboy.repository;

import cn.ntboy.model.Types;
import cn.ntboy.model.TypesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    long countByExample(TypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int deleteByExample(TypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int insert(Types record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int insertSelective(Types record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    List<Types> selectByExample(TypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    Types selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int updateByExampleSelective(@Param("record") Types record, @Param("example") TypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int updateByExample(@Param("record") Types record, @Param("example") TypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int updateByPrimaryKeySelective(Types record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int updateByPrimaryKey(Types record);
}