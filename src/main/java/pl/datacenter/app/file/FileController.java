package pl.datacenter.app.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.datacenter.app.company.Company;
import pl.datacenter.app.company.CompanyService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("files")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public String list(Model model){
        List<DBFile> files = fileService.findAll();
        List<Company> companies = companyService.findAll();
        model.addAttribute("file", new DBFile());
        model.addAttribute("files", files);
        model.addAttribute("companies", companies);
        return "fileList";
    }

    @PostMapping("/list")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("company") Company company) {
        fileService.saveFile(file, company);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        fileService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/download/{id}")
    public String download(@PathVariable Long id, HttpServletResponse response) throws IOException {
        DBFile file = fileService.findById(id);
        response.setContentType(file.getFileType());
        response.setContentLength(file.getData().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + file.getFileName() +"\"");
        FileCopyUtils.copy(file.getData(), response.getOutputStream());
        return "redirect:../list";
    }
}
