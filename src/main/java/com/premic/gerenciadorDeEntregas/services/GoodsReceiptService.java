package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.entities.GoodsReceipt;
import com.premic.gerenciadorDeEntregas.entities.ReceiptItem;
import com.premic.gerenciadorDeEntregas.repositories.GoodsReceiptRepository;
import com.premic.gerenciadorDeEntregas.repositories.ReceiptItemRepository;
import com.premic.gerenciadorDeEntregas.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import static java.time.Instant.now;

@Service
public class GoodsReceiptService {

    @Autowired
    private GoodsReceiptRepository repository;

    @Autowired
    private ReceiptItemRepository receiptItemRepository;

    @Autowired
    private ProductService productService;

    public List<GoodsReceipt> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public GoodsReceipt findById(Long id) {
        Optional<GoodsReceipt> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public GoodsReceipt insert(GoodsReceipt obj) {
        obj.setId(null);
        obj.setDateReceipt(now());
        for (ReceiptItem items : obj.getReceiptItems()) {
            items.setGoodsReceipt(obj);
        }
        repository.save(obj);
        receiptItemRepository.saveAll(obj.getReceiptItems());
        return obj;
    }
}
