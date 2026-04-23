package com.tms.services;

import com.tms.model.Role;
import com.tms.model.Security;
import com.tms.model.User;
import com.tms.model.dto.UserDto;
import com.tms.repository.SecurityRepository;
import com.tms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;


@Service
public class SecurityService {
    private final SecurityRepository SecurityRepository;
    private final UserRepository userRepository;
    private final TransactionTemplate transactionTemplate;

    @Autowired
    public SecurityService (SecurityRepository SecurityRepository, TransactionTemplate transactionTemplate, UserRepository userRepository) {
        this.SecurityRepository = SecurityRepository;
        this.userRepository = userRepository;
        this.transactionTemplate = transactionTemplate;
    }

    public UserDto registration(String firstName, String lastName, int age, String username, String password, String email) {
        //1. Start transaction
        //2. Save user
        //3. Save security
        //4. Переносим поля из пользователя в UserDto

        return transactionTemplate.execute(action -> {
           User user = new User(); // Создали объекта пользователя и перенесли все данные из формы в этот объект
           user.setFirstName(firstName);
           user.setLastName(lastName);
           user.setAge(age);
           user.setEmail(email);
           user.setCreated(LocalDateTime.now());
           user.setUpdated(LocalDateTime.now());
           User savedUser = userRepository.saveUser(user);

            Security security = new Security();
            security.setUsername(username);
            security.setPassword(password);
            security.setRole(Role.USER);
            security.setUserId(savedUser.getId());
            SecurityRepository.saveSecurity(security);

            UserDto userDto = new UserDto();
            userDto.setId(savedUser.getId());
            userDto.setFirstName(savedUser.getFirstName());
            userDto.setLastName(savedUser.getLastName());
            userDto.setAge(savedUser.getAge());
            return userDto;
        });
    }
}
