package kr.co.first.gotoeat.interfaces;

import kr.co.first.gotoeat.application.ReviewService;
import kr.co.first.gotoeat.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class ReviewController
{
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> list()
    {
        List<Review> reviews = reviewService.getReviews();

        return reviews;
    }

}
