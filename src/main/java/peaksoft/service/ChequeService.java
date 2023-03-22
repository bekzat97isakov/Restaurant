package peaksoft.service;

import peaksoft.dto.request.ChequeOfRestaurantAmountDayRequest;
import peaksoft.dto.request.ChequeOneDayTotalAmountRequest;
import peaksoft.dto.request.ChequeRequest;
import peaksoft.dto.request.ChequeUpdateRequest;
import peaksoft.dto.response.*;
import peaksoft.entity.Cheque;

import java.util.List;
import java.util.Set;

public interface ChequeService {
    SimpleResponse saveCheque(ChequeRequest chequeRequest);
    Set<ChequeResponse> getAllCheque();
    //    ChequeFinalResponse getById(Long id);
    SimpleResponse updateCheque(Long id, ChequeUpdateRequest chequeRequest);
    SimpleResponse deleteById(Long id);
    ChequeFinalResponse findById(Long id);

    ChequeOneDayTotalAmountResponse findAllChequesOneDayTotalAmount(ChequeOneDayTotalAmountRequest request);

    ChequeOfRestaurantAmountDayResponse countRestGrantTotalForDay(ChequeOfRestaurantAmountDayRequest chequeOfRestaurantAmountDayRequest);
}
