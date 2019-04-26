package com.leviathan.springbatch.batch;

import com.leviathan.springbatch.model.User;
import com.leviathan.springbatch.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends User> list) throws Exception {
        System.out.println("Data saved for users: " + list);
        userRepository.save(list);
    }

}
