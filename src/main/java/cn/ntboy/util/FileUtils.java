package cn.ntboy.util;

import lombok.NonNull;

public class FileUtils {

    /**
     * 获取文件的扩展名,例如 img.jpg 返回.jpg
      * @param filename 文件名
     * @return 扩展名,如果没有扩展名返回空字串
     */
    public static String getFileExtension(@NonNull String filename){
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex!=-1) {
            return filename.substring(dotIndex);
        }
        return "";
    }

    /**
     * 修改文件名 并保留扩展名
     * @param filename 原文件名
     * @param newName 新的文件名
     * @return 保留扩展名的新文件名
     */
    public static String renameFile(@NonNull String filename,@NonNull String newName){
        return renameFile(filename, newName,true);
    }

    /**
     * 修改文件名
     * @param filename 原文件名
     * @param newName 新的文件名
     * @param keepExt 是否保留文件扩展名
     * @return 新的文件名
     */
    public static String renameFile(@NonNull String filename,@NonNull String newName,boolean keepExt){
        if(keepExt){
            String extension = getFileExtension(filename);
            newName+=extension;
        }
        return newName;
    }
}
