package com.jake.csamanagement.service;

import com.jake.csamanagement.dao.StatisticsMapper;
import com.jake.csamanagement.model.RoomRecordStatisticsObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    StatisticsMapper statisticsMapper;

    public List<RoomRecordStatisticsObject> getRoomRecordStatistics() {
        List<RoomRecordStatisticsObject> rrsoList = new ArrayList<>();
        String nameArray[] = {"<=6分", "6-7分", "7-8分", "8-9分", "9-10分"};

        RoomRecordStatisticsObject rrso = new RoomRecordStatisticsObject();
        rrso.setName(nameArray[0]);
        rrso.setValue(statisticsMapper.getRoomRecordStatistics(1+"", 0, 6));
        rrsoList.add(rrso);
        RoomRecordStatisticsObject rrso2 = new RoomRecordStatisticsObject();
        rrso2.setName(nameArray[1]);
        rrso2.setValue(statisticsMapper.getRoomRecordStatistics(2+"", 7, 6));
        rrsoList.add(rrso2);
        RoomRecordStatisticsObject rrso3 = new RoomRecordStatisticsObject();
        rrso3.setName(nameArray[2]);
        rrso3.setValue(statisticsMapper.getRoomRecordStatistics(2+"", 9, 7));
        rrsoList.add(rrso3);
        RoomRecordStatisticsObject rrso4 = new RoomRecordStatisticsObject();
        rrso4.setName(nameArray[3]);
        rrso4.setValue(statisticsMapper.getRoomRecordStatistics(2+"", 9, 8));
        rrsoList.add(rrso4);
        RoomRecordStatisticsObject rrso5 = new RoomRecordStatisticsObject();
        rrso5.setName(nameArray[4]);
        rrso5.setValue(statisticsMapper.getRoomRecordStatistics(2+"", 10, 9));
        rrsoList.add(rrso5);
        return rrsoList;
    }

    public Integer[] getAlienStatistics(){
        Integer intArray[]=new Integer[7];
        for (int i=0;i<intArray.length;i++)
        {
            intArray[i]=statisticsMapper.getAlienStatistics(i);
        }
        return intArray;
    }
}
