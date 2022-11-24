package prohvataeva.springsecurity.service;

import org.springframework.stereotype.Service;
import prohvataeva.springsecurity.repository.MyRepository;

@Service
public class MyService {

    MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
