package ro.ubb.donation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.donation.core.model.Center;
import ro.ubb.donation.core.repository.CenterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    private CenterRepository centerRepository;

    @Override
    public List<Center> findAll() {
        return this.centerRepository.findAll();
    }

    @Override
    public Optional<Center> findCenter(int centerId) {
        return this.centerRepository.findById(centerId);
    }
}
