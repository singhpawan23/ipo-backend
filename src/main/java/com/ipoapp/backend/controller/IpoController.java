/*
package com.ipoapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.ipoapp.backend.model.Ipo;
import com.ipoapp.backend.repository.IpoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ipos")
public class IpoController {

    @Autowired
    private IpoRepository repo;

    // GET all IPOs
    @GetMapping
    public List<Ipo> getAll() {
        return repo.findAll();
    }

    // CREATE IPO
    @PostMapping
    public Ipo create(@RequestBody Ipo ipo) {
        return repo.save(ipo);
    }

    // UPDATE IPO (Modify)
    @PutMapping("/{id}")
    public Ipo updateIpo(@PathVariable Long id, @RequestBody Ipo newData) {

        Ipo ipo = repo.findById(id).orElseThrow();

        ipo.setCompanyName(newData.getCompanyName());
        ipo.setOpenDate(newData.getOpenDate());
        ipo.setCloseDate(newData.getCloseDate());
        ipo.setIssueSize(newData.getIssueSize());
        ipo.setPriceBand(newData.getPriceBand());
        ipo.setSubscription(newData.getSubscription());
        ipo.setGmp(newData.getGmp());
        ipo.setStatus(newData.getStatus());

        return repo.save(ipo);
    }
    // GET IPO DETAILS
    @GetMapping("/{id}")
public ResponseEntity<Ipo> getIpoById(@PathVariable Long id) {
    Ipo ipo = repo.findById(id).orElse(null);
    if (ipo == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(ipo);
}
}
*/

/*
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ipos")
public class IpoController {

    @Autowired
    private IpoRepository repo;

    @GetMapping
    public List<Ipo> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Ipo getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Ipo create(@RequestBody Ipo ipo) {
        return repo.save(ipo);
    }
   @GetMapping("/{id}")
public Optional<Ipo> getIpo(@PathVariable Long id) {
    return repo.findById(id);
}
    @PutMapping("/{id}")
    public Ipo update(@PathVariable Long id, @RequestBody Ipo newData) {

        Ipo ipo = repo.findById(id).orElseThrow();

        ipo.setCompanyName(newData.getCompanyName());
        ipo.setOpenDate(newData.getOpenDate());
        ipo.setCloseDate(newData.getCloseDate());
        ipo.setIssuePrice(newData.getIssuePrice());
        ipo.setPriceBand(newData.getPriceBand());
        ipo.setSubscription(newData.getSubscription());
        ipo.setGmp(newData.getGmp());
        ipo.setStatus(newData.getStatus());
        ipo.setDetails(newData.getDetails());  // ⭐ IMPORTANT

        return repo.save(ipo);
    }
    @PutMapping("/{id}")
public Ipo updateIpo(@PathVariable Long id, @RequestBody Ipo updatedIpo) {
    return repo.findById(id).map(ipo -> {
        ipo.setCompanyName(updatedIpo.getCompanyName());
        ipo.setOpenDate(updatedIpo.getOpenDate());
        ipo.setCloseDate(updatedIpo.getCloseDate());
        ipo.setDetails(updatedIpo.getDetails());
        return repo.save(ipo);
    }).orElse(null);
}

}
*/
/* 
package com.ipoapp.backend.controller;

import com.ipoapp.backend.model.Ipo;
import com.ipoapp.backend.repository.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ipos")
public class IpoController {

    @Autowired
    private IpoRepository repo;

    // GET all
    @GetMapping
    public List<Ipo> getAll() {
        return repo.findAll();
    }

    // GET one
    @GetMapping("/{id}")
    public ResponseEntity<Ipo> getOne(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE
    @PostMapping
    public Ipo create(@RequestBody Ipo ipo) {
        return repo.save(ipo);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Ipo> update(@PathVariable Long id, @RequestBody Ipo newData) {
        return repo.findById(id)
            .map(ipo -> {
                // copy allowed fields:
                ipo.setCompanyName(newData.getCompanyName());
                ipo.setType(newData.getType());
                ipo.setOpenDate(newData.getOpenDate());
                ipo.setCloseDate(newData.getCloseDate());
                ipo.setIssuePrice(newData.getIssuePrice());
                ipo.setIssueSize(newData.getIssueSize());
                ipo.setPriceBand(newData.getPriceBand());
                ipo.setSubscription(newData.getSubscription());
                ipo.setGmp(newData.getGmp());
                ipo.setStatus(newData.getStatus());
                repo.save(ipo);
                return ResponseEntity.ok(ipo);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
*/

package com.ipoapp.backend.controller;

import com.ipoapp.backend.model.Ipo;
import com.ipoapp.backend.repository.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // allow react local dev
@RestController
@RequestMapping("/api/ipo")
public class IpoController {

    @Autowired
    private IpoRepository repo;

    @GetMapping
    public List<Ipo> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ipo> getOne(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ipo create(@RequestBody Ipo ipo) {
        return repo.save(ipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ipo> update(@PathVariable Long id, @RequestBody Ipo updated) {
        return repo.findById(id).map(ipo -> {
            // copy fields - update all editable fields
            ipo.setCompanyName(updated.getCompanyName());
            ipo.setGmp(updated.getGmp());
            ipo.setSubscription(updated.getSubscription());
            ipo.setType(updated.getType());
            ipo.setOpenDate(updated.getOpenDate());
            ipo.setCloseDate(updated.getCloseDate());
            ipo.setPriceBand(updated.getPriceBand());
            ipo.setIssueSize(updated.getIssueSize());   
            ipo.setStatus(updated.getStatus());
            ipo.setDescription(updated.getDescription());
            repo.save(ipo);
            return ResponseEntity.ok(ipo);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
