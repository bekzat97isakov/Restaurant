package peaksoft.service;

import peaksoft.entity.Cheque;

import java.util.List;

public interface ChequeService {
    Cheque saveCheque(Cheque cheque);
    List<Cheque> getAllCheque();
    Cheque getByIdCheque(Long chequeId);
    Cheque updateByIdCheque(Long chequeId, Cheque cheque);
    void deleteByIdCheque(Long chequeId);
}
