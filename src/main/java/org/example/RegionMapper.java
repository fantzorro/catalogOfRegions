package org.example;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionMapper {
    Region findById(long regionId);

    int addRegion(Region region);

    int deleteRegion(long regionId);

    int updateRegion(Region region);
}
