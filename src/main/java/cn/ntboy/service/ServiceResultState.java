package cn.ntboy.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceResultState<T> {
    public static<T> ServiceResultState<T> wrap(Integer stateCode, T payload){
        return new ServiceResultState<T>(stateCode,payload);
    }

    /**
     * 状态码 标识业务 成功 失败 出错 等情况
     */
    private Integer stateCode;

    /**
     * 业务负载数据
     */
    private T payload;
}
