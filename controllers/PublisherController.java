package com.example.demo.controllers;

import com.example.demo.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {

    private final PublisherRepository publisherRepo;

    public PublisherController(PublisherRepository publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @RequestMapping("/publishers")
    public String getPublishers(Model publisherModel)
    {
        publisherModel.addAttribute("publishers", publisherRepo.findAll());

        return "publishers/list";
    }

}
