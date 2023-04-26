package nulp.trspo.aviatickets.user.domain.service;

import lombok.RequiredArgsConstructor;
import nulp.trspo.aviatickets.user.persistence.entity.UserEntity;
import nulp.trspo.aviatickets.user.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity addUser(UserEntity user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }

    public Optional<UserEntity> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    public UserEntity updateUserById(Long userId, UserEntity newUser){
        newUser.setId(userId);
        return userRepository.save(newUser);
    }

}
