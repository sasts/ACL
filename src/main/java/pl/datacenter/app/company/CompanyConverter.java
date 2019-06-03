package pl.datacenter.app.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CompanyConverter implements Converter<String, Company> {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company convert(String s) {
        return companyRepository.findById(Long.parseLong(s)).orElse(null);
    }

}
