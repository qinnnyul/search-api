package com.thoughtworks.resource;

import com.thoughtworks.model.QueryParameters;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SearchController {

    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ResponseBody
    public QueryParameters search(QueryParameters queryParameters) {
        return queryParameters;
    }


}
