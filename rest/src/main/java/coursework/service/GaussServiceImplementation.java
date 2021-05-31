package coursework.service;

import coursework.model.Gauss;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GaussServiceImplementation implements GaussService {
    private Gauss gauss;

    @Override
    public void create(Gauss gauss) { this.gauss = gauss; }

    @Override
    public Gauss readAll() {
        if (gauss != null) { gauss.solve(); }
        return gauss;
    }

    @Override
    public void delete() {
        this.gauss = null;
    }
}
