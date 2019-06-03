package pl.datacenter.app.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class FileConverter implements Converter<String, DBFile> {

    @Autowired
    FileRepository fileRepository;

    @Override
    public DBFile convert(String s) {
        return fileRepository.findById(Long.parseLong(s)).orElse(null);
    }
}
