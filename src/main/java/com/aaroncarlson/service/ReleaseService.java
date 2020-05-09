package com.aaroncarlson.service;

import com.aaroncarlson.model.Release;
import com.aaroncarlson.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;

    public List<Release> getAllReleases() {
        return releaseRepository.findAll();
    }

}
