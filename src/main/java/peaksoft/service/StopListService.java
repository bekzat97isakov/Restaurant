package peaksoft.service;

import peaksoft.entity.StopList;

import java.util.List;

public interface StopListService {
    StopList saveStopList(StopList stopList);
    List<StopList> getAllStopList();
    StopList getByIdStopList(Long stopListId);
    StopList updateByIdStopList(Long stopListId, StopList stopList);
    void deleteByIdStopList(Long stopListId);
}
