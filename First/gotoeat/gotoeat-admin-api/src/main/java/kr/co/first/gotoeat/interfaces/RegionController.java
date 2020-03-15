package kr.co.first.gotoeat.interfaces;

import kr.co.first.gotoeat.application.RegionService;
import kr.co.first.gotoeat.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping("/regions")
    public ResponseEntity<?> create(
            @RequestBody Region resource
    ) throws URISyntaxException
    {
        String name = resource.getName();
        Region region = regionServce.addRegion(name);
        String url = "/regions/" + region.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }

}
