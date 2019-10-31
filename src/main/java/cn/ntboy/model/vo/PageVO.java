package cn.ntboy.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 总数
     */
    private Long total;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 查询出的数据
     */
    List<T> data;

}
