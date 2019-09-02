package com.shijna;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Component
public class ClassClient {

    ClassEntity getByCourse(String course)
    {
        RestOperations restOperations=new RestTemplate();
        ClassEntity entity= restOperations.getForEntity("http://launcher2-patient-porcupine.apps.pcf.paltraining.perficient.com/classes/"+course, ClassEntity.class).getBody();
        if(entity==null)
        {
            return null;
        }
        //System.out.println(entity.className);
        return entity;
    }
}
