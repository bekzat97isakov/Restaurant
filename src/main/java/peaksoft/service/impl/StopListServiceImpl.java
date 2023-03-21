package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.StopList;
import peaksoft.repository.StopListRepository;
import peaksoft.service.StopListService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StopListServiceImpl implements StopListService {
    private final StopListRepository stopListRepository;

    @Override
    public StopList saveStopList(StopList stopList) {
        return stopListRepository.save(stopList);
    }

    @Override
    public List<StopList> getAllStopList() {
        return stopListRepository.findAll();
    }

    @Override
    public StopList getByIdStopList(Long stopListId) {
        return stopListRepository.findById(stopListId).get();
    }

    @Override
    public StopList updateByIdStopList(Long stopListId, StopList stopList) {
        StopList stopList1 = getByIdStopList(stopListId);
        stopList1.setReason(stopList.getReason());
        stopList1.setDate(stopList.getDate());
        stopListRepository.save(stopList1);
        return stopList1;
    }

    @Override
    public void deleteByIdStopList(Long stopListId) {
        stopListRepository.deleteById(stopListId);
    }
}
