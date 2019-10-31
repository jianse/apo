package cn.ntboy.service;

import java.io.File;

/**
 * 统一文件服务, 统一文件的存储, 读取等操作, 统一进行存储库配置等
 */
public interface FileService {
    String getRepository();

    void setRepository(String path);

    File getFile(String filename);

    byte[] getFileAsBytes(String filename);

    void saveFile(byte[] data,String filename);

    void saveFile(byte[] data,String filename,String extension);

    String saveFileUseGenerateName(byte[] data,String extension);
}
