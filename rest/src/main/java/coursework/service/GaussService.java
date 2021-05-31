package coursework.service;

import coursework.model.Gauss;
import java.util.List;

public interface GaussService {
    void create(Gauss gauss);

    Gauss readAll();

    void delete();
}
