package com.premic.gerenciadorDeEntregas.resources;

import com.premic.gerenciadorDeEntregas.entities.Customer;
import com.premic.gerenciadorDeEntregas.entities.GoodsReceipt;
import com.premic.gerenciadorDeEntregas.services.GoodsReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/goodsreceipts")
public class GoodsReceiptResource {

    @Autowired
    private GoodsReceiptService service;

    @GetMapping
    public ResponseEntity<List<GoodsReceipt>> findAll() {
        List<GoodsReceipt> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GoodsReceipt> findById(@PathVariable Long id) {
        GoodsReceipt obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<GoodsReceipt> insert(@Valid @RequestBody GoodsReceipt obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}