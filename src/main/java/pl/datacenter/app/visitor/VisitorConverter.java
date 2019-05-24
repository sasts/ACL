package pl.datacenter.app.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class VisitorConverter implements Converter<String, Visitor> {

    @Autowired
    VisitorRepository visitorRepository;

    @Override
    public Visitor convert(String s) {
        return visitorRepository.findOne(Long.parseLong(s));
    }
}
