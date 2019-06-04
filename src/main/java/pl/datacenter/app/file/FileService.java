package pl.datacenter.app.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.datacenter.app.company.Company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public DBFile saveFile(MultipartFile file, Company company) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
            dbFile.setCompany(company);

            return fileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFile(Long id) throws FileNotFoundException {
        return fileRepository.findById(id).orElseThrow(() -> new FileNotFoundException("File not found with id " + id));
    }

    public List<DBFile> findAll() {
        return fileRepository.findAll();
    }

    public void delete(Long id) {
        fileRepository.deleteById(id);
    }

    public DBFile findById(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    public List<DBFile> findAllByCompany(Long id) {
        return fileRepository.findByCompanyIdOrderByFileName(id);
    }

}
