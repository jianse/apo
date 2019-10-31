package cn.ntboy.service;

import com.google.protobuf.ServiceException;

import java.io.File;

/**
 * 统一文件服务, 统一文件的存储, 读取等操作, 统一进行存储库配置等
 */
public interface FileService {

    /**
     * 获取存储库的路径
     * @return 存储库的绝对路径
     */
    String getRepository();

    /**
     * 设置存储库的绝对路径,必须为绝对路径, 当文件夹不存在时会自行创建, 不能创建时会抛出运行时异常
     * @param path 绝对路径
     * @exception ServiceException 不能创建文件夹时
     */
    void setRepository(String path);

    /**
     * 通过文件名获取文件
     * @param filename 要获取的文件的文件名
     * @return 返回文件包装类, 包含状态码
     */
    ServiceResultState<File> getFile(String filename);

    /**
     * 以byte数组的方式返回文件信息
     * @param filename 要查找的文件名
     * @return 返回文件包装类, 包含状态码
     */
    ServiceResultState<byte[]> getFileAsBytes(String filename);

    /**
     * 保存文件
     * @param data 文件数据
     * @param filename 文件名
     * @return 状态码包装类
     */
    ServiceResultState saveFile(byte[] data,String filename);

    /**
     * 保存文件
     * @param data 文件数据
     * @param filename 文件名
     * @param extension 文件扩展名
     * @return 状态码包装类
     */
    ServiceResultState saveFile(byte[] data,String filename,String extension);

    /**
     * 使用自动生成的文件名保存文件
     * @param data 文件数据
     * @param extension 扩展名
     * @return 状态码和文件名的包装类
     */
    ServiceResultState<String> saveFileUseGenerateName(byte[] data,String extension);
}
