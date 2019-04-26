package com.leviathan.springbatch.batch;

import com.leviathan.springbatch.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> map = new HashMap<>();

    public Processor() {
        map.put("001", "Backend");
        map.put("002", "Frontend");
        map.put("003", "QA");
    }

    @Override
    public User process(User user) throws Exception {
        user.setDept(map.get(user.getDept()));
        return user;
    }

}
