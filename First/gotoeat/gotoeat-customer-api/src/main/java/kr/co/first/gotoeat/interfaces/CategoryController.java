package kr.co.first.gotoeat.interfaces;

import kr.co.first.gotoeat.application.CategoryService;
import kr.co.first.gotoeat.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController
{
    @Autowired
    private CategoryService categoryservice;

    @GetMapping("/categories")
    public List<Category> list()
    {
        List<Category> categories = categoryservice.getCategories();

        return categories;
    }



}
