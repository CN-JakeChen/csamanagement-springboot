package com.jake.csamanagement.service;

import com.jake.csamanagement.dao.BedMapper;
import com.jake.csamanagement.entity.Bed;
import com.jake.csamanagement.entity.NewBed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedService {

    @Autowired
    BedMapper bedMapper;
    public List<Bed> getBedList(int roomInfo)
    {
        return bedMapper.getBedInfo(roomInfo);
    }

    public int addBed(NewBed newBed)
    {
        if(bedMapper.searchABed(newBed.getRoomId(),newBed.getBedNumber())==0)
        {
            return bedMapper.addBed(newBed);
        }
        return 0;
    }

    public int deleteBed(String studentId)
    {
        return bedMapper.deleteBed(studentId);
    }
}
