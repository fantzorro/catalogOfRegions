package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/regions")
public class RegionController {
    private RegionDAO regionDAO;

    @Autowired
    public RegionController(RegionDAO regionDAO) {
        this.regionDAO = regionDAO;
    }

    @Cacheable("regions")
    @RequestMapping(value = "/{regionId}", method = RequestMethod.GET)
    public Region getRegion(@PathVariable long regionId) {
        return regionDAO.selectRegionById(regionId);
    }

    @Cacheable(value = "regions", key = "#name")
    @RequestMapping("/add")
    public Region addRegion(@RequestParam(value = "name", defaultValue = "empty") String name, @RequestParam(value = "short_name", defaultValue = "empty") String shortName) {
        Region region = new Region(name, shortName);
        return regionDAO.addRegion(region);
    }

    @CacheEvict("regions")
    @RequestMapping("/delete")
    public int deleteRegion(@RequestParam(value = "id") long regionId) {
        return regionDAO.deleteRegion(regionId);
    }

    @Cacheable(value = "regions", key = "#name")
    @RequestMapping("/update")
    public Region updateRegion(@RequestParam(value = "id") long regionId, @RequestParam(value = "name", defaultValue = "empty") String name, @RequestParam(value = "short_name", defaultValue = "empty") String shortName) {
        Region region = new Region(regionId, name, shortName);
        return regionDAO.updateRegion(region);
    }

}
