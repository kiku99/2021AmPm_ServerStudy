package kr.ac.jbnu.jaehyeon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> origin/master
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
<<<<<<< HEAD

    private static HashMap<String, ArrayList<Map<String, Object>>> testDBHashMap = new HashMap<String, ArrayList<Map<String, Object>>>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAllResponseEntity(HttpServletRequest request) {
        ResponseEntity<?> responseEntity = null;

        if (!testDBHashMap.isEmpty()) {
            responseEntity = new ResponseEntity<>(testDBHashMap, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("NOT_FOUND", HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAllResponseEntity(HttpServletRequest request, @PathVariable String id) {
        ResponseEntity<?> responseEntity = null;

        if (!testDBHashMap.isEmpty()) {
            if (id != null && !id.equals("") && testDBHashMap.containsKey(id)) {
                responseEntity = new ResponseEntity<>(testDBHashMap.get(id), HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>("NOT_FOUND", HttpStatus.NOT_FOUND);
            }
        } else {
            responseEntity = new ResponseEntity<>("NOT_FOUND", HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getAllResponseEntity(HttpServletRequest request, @PathVariable String id, @RequestBody Map<String, Object> requestMap) {
        ResponseEntity<?> responseEntity = null;
        ArrayList<Map<String, Object>> postValueArrayList = null;

        if (id != null && !id.equals("")) {
            if (testDBHashMap.containsKey(id)) {
                postValueArrayList = testDBHashMap.get(id);
            } else {
                postValueArrayList = new ArrayList<Map<String, Object>>();
            }

            postValueArrayList.add(requestMap);

            if (testDBHashMap.containsKey(id)) {
                testDBHashMap.replace(id, postValueArrayList);
            } else {
                testDBHashMap.put(id, postValueArrayList);
            }

            responseEntity = new ResponseEntity<>(requestMap, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("NOT_FOUND", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> deleteResponseEntity(HttpServletRequest request, @PathVariable String id) {
        ResponseEntity<?> responseEntity = null;
        ArrayList<Map<String, Object>> postValueArrayList = null;

        if (id != null && !id.equals("")) {
            if (testDBHashMap.containsKey(id)) {
                testDBHashMap.remove(id);
                responseEntity = new ResponseEntity<>("", HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>("NOT_CONTAIN", HttpStatus.BAD_REQUEST);
            }

        }
        else {
            responseEntity = new ResponseEntity<>("NOT_CONTAIN", HttpStatus.BAD_REQUEST);
        }

=======
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
>>>>>>> origin/master
        return responseEntity;
    }
}
