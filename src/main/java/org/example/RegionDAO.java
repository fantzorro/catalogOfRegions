package org.example;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegionDAO {
    private final SqlSession sqlSession;

    public RegionDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Region selectRegionById(long regionId) {
        RegionMapper mapper = sqlSession.getMapper(RegionMapper.class);
        Region region = mapper.findById(regionId);
        return region;
    }

    public Region addRegion(Region region) {
        RegionMapper mapper = sqlSession.getMapper(RegionMapper.class);
        mapper.addRegion(region);
        return region;
    }

    public int deleteRegion(long regionId) {
        RegionMapper mapper = sqlSession.getMapper(RegionMapper.class);
        return mapper.deleteRegion(regionId);
    }

    public Region updateRegion(Region region) {
        RegionMapper mapper = sqlSession.getMapper(RegionMapper.class);
        mapper.updateRegion(region);
        return region;
    }
}
