package pl.datacenter.app.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void create(Event event) {
        eventRepository.save(event);
    }

    public Event read(Long id) {
        return eventRepository.findOne(id);
    }

    public void update(Event event) {
        eventRepository.save(event);
    }

    public void delete(Long id) {
        eventRepository.delete(id);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public List<Event> findAllFromDate(Date date) {
        return eventRepository.findAllByDate(date);
    }
}

