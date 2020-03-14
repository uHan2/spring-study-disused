package kr.co.first.gotoeat.interfaces;

import kr.co.first.gotoeat.application.RegionService;
import kr.co.first.gotoeat.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController
{
    @Autowired
    private RegionService regionServce;

    @GetMapping("/regions")
    public List<Region> list()
    {
        List<Region> regions =regionServce.getRegions();


        return regions;
    }

}
