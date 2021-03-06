package cn.ntboy.repository;

import cn.ntboy.model.Menus;
import cn.ntboy.model.MenusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenusMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    long countByExample(MenusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int deleteByExample(MenusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int insert(Menus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int insertSelective(Menus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    List<Menus> selectByExample(MenusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    Menus selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int updateByExampleSelective(@Param("record") Menus record, @Param("example") MenusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int updateByExample(@Param("record") Menus record, @Param("example") MenusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int updateByPrimaryKeySelective(Menus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menus
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    int updateByPrimaryKey(Menus record);
}