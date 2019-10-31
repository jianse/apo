package cn.ntboy.service.impl;

import cn.ntboy.service.FileService;
import cn.ntboy.service.ServiceException;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.util.FileUtils;
import cn.ntboy.util.tx.Service;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    private String repository = "E://apo";

    @Override
    public String getRepository() {
        return repository;
    }

    @Override
    public void setRepository(String path) {
        init(path);
    }

    public FileServiceImpl() {
        init(repository);
    }

    private void init(String path) {
        Path repo = Paths.get(path);
        if (!repo.isAbsolute()) {
            throw new ServiceException("repository must be absolute");
        }
        if(Files.notExists(repo)){
            try {
                Files.createDirectories(repo);
            } catch (IOException e) {
                throw new ServiceException(e);
            }
        }
        if(Files.isDirectory(repo)){
            repository = path;
            return;
        }
        throw new ServiceException(path+" is not a directory");
    }

    @Override
    public ServiceResultState<File> getFile(String filename) {
        Path path = Paths.get(repository, filename);
        if (Files.notExists(path)||!Files.isRegularFile(path)) {
            return ServiceResultState.wrap(404,null);
        }

        return ServiceResultState.wrap(200,path.toFile());
    }

    @Override
    public ServiceResultState<byte[]> getFileAsBytes(String filename) {
        Path path = Paths.get(repository, filename);
        if (Files.notExists(path)||!Files.isRegularFile(path)) {
            return ServiceResultState.wrap(404,null);
        }
        byte[] bytes =null;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ServiceException("IOException occur during read file",e);
        }
        return ServiceResultState.wrap(200,bytes);
    }

    @Override
    public ServiceResultState<String> saveFile(byte[] data, String filename) {
        Path path = Paths.get(repository, filename);
        try {
            Files.write(path,data);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("an exception occur during write file",e);
        }

        return ServiceResultState.wrap(200,null);
    }

    @Override
    public ServiceResultState<String> saveFile(byte[] data, String filename, String extension) {
        String fullName = FileUtils.filenameExtensionCombine(filename, extension);
        ServiceResultState<String> result = saveFile(data, fullName);
        if (result.getStateCode()==200) {
            result.setPayload(fullName);
        }
        return result;
    }

    @Override
    public ServiceResultState<String> saveFileUseGenerateName(byte[] data, String extension) {
        String name = UUID.randomUUID().toString();
        return saveFile(data,name,extension);
    }
}
