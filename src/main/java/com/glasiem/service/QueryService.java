package com.glasiem.service;

import com.glasiem.entity.AgencyEntity;
import com.glasiem.entity.GenerationEntity;
import com.glasiem.entity.VTuberEntity;
import com.glasiem.repository.queries.AgencyQueryRepo;
import com.glasiem.repository.queries.GenerationQueryRepo;
import com.glasiem.repository.queries.ManagerQueryRepo;
import com.glasiem.repository.queries.VTuberQueryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {

    @Autowired
    VTuberQueryRepo vtuberQueryRepo;

    @Autowired
    GenerationQueryRepo generationQueryRepo;

    @Autowired
    AgencyQueryRepo agencyQueryRepo;

    @Autowired
    ManagerQueryRepo managerQueryRepo;

    public String solveQuery1(String contents){
        String result= "";
        List<VTuberEntity> queryList = vtuberQueryRepo.findVTubersByAgencyName(contents);
        for (VTuberEntity vtuber: queryList) {
            result += vtuber.getName() + "; ";
        }
        return result;
    }

    public String solveQuery2(String contents){
        String result= "";
        List<GenerationEntity> queryList = generationQueryRepo.findGenerationsByVTuberName(contents);
        for (GenerationEntity generation: queryList) {
            result += generation.getName() + "; ";
        }
        return result;
    }

    public String solveQuery3(String contents){
        Integer count = vtuberQueryRepo.findVTubersCountByAgencyName(contents);
        String result = count.toString();
        return result;
    }

    public String solveQuery4(Integer contents){
        String result= "";
        List<AgencyEntity> queryList = agencyQueryRepo.findAgenciesByGenerationCount(contents);
        for (AgencyEntity agency: queryList) {
            result += agency.getName() + "; ";
        }
        return result;
    }

    public String solveQuery5(String contents){
        String queryRes = managerQueryRepo.findManagerByVTuberName(contents);
        return queryRes;
    }

    public String solveQuery6(String contents){
        String result= "";
        List<VTuberEntity> queryList = vtuberQueryRepo.findVTubersByMediaSet1(contents);
        for (VTuberEntity vtuber: queryList) {
            result += vtuber.getName() + "; ";
        }
        return result;
    }

    public String solveQuery7(String contents){
        String result= "";
        List<VTuberEntity> queryList = vtuberQueryRepo.findVTubersByMediaSet2(contents);
        for (VTuberEntity vtuber: queryList) {
            result += vtuber.getName() + "; ";
        }
        return result;
    }

    public String solveQuery8(String contents){
        String result= "";
        List<VTuberEntity> queryList = vtuberQueryRepo.findVTubersByMediaSet3(contents);
        for (VTuberEntity vtuber: queryList) {
            result += vtuber.getName() + "; ";
        }
        return result;
    }
}
