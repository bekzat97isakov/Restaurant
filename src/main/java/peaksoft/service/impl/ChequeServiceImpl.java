package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Cheque;
import peaksoft.repository.ChequeRepository;
import peaksoft.service.ChequeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChequeServiceImpl implements ChequeService {
    private final ChequeRepository chequeRepository;
    @Override
    public Cheque saveCheque(Cheque cheque) {
        return chequeRepository.save(cheque);
    }

    @Override
    public List<Cheque> getAllCheque() {
        return chequeRepository.findAll();
    }

    @Override
    public Cheque getByIdCheque(Long chequeId) {
        return chequeRepository.findById(chequeId).get();
    }

    @Override
    public Cheque updateByIdCheque(Long chequeId, Cheque cheque) {
        Cheque cheque1 = getByIdCheque(chequeId);
        cheque1.setPriceAverage(cheque.getPriceAverage());
        cheque1.setCreatedAt(cheque.getCreatedAt());
        chequeRepository.save(cheque1);
        return cheque1;
    }

    @Override
    public void deleteByIdCheque(Long chequeId) {
        chequeRepository.deleteById(chequeId);
    }
}
