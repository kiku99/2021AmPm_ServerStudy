package kr.ac.jbnu.jaehyeon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> responseEntity(HttpServletRequest request, @PathVariable String id){
        ResponseEntity<?> responseEntity = null;
        Map<String, Object> voMap = null;

        if (id != null && !id.equals("")){
            voMap = new HashMap<String, Object>();

            voMap.put("name", "김재현");
            voMap.put("age", 23);

            voMap.put("books", new HashMap<String , Object>(){{
                put("book3", new HashMap<String , Object>(){{
                    put("name", "디지털공학개론");
                }});
                put("book1", "마션");
                put("book2", "소프트웨어공학개론");
            }});

            responseEntity = new ResponseEntity<>(voMap, HttpStatus.OK);
        }
        else{
            responseEntity = new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
