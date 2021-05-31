package coursework.controllers;

import coursework.model.Gauss;
import coursework.service.GaussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/rest/gauss")
public class GaussController {
    private final GaussService GaussService;

    @Autowired
    public GaussController(GaussService GaussService) {
        this.GaussService = GaussService;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody Gauss gauss) {
        GaussService.create(gauss);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Gauss> read() {
        final Gauss gauss = GaussService.readAll();
        return new ResponseEntity<>(gauss, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete() {
        GaussService.delete();
        final boolean deleted = true;

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
