package org.example.chapter09_practice2.service;

import org.example.chapter09_practice2.UserNotFoundException.UserNotFoundException;
import org.example.chapter09_practice2.model.User;
import org.example.chapter09_practice2.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> userList = new ArrayList<>();

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        // 방어적 복사 - 배열 반환
        //
        return new ArrayList<>(userList);

    }

    @Override
    public User findUserById(int id) {

        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        // for문 돌고 조건 맞는것이 없으면 밑에꺼는 무조건 실행됨.
        throw new UserNotFoundException(id + "의 번호는 없습니다.");
    }

    @Override
    public List<User> findUsersByName(String name) {

        List<User> usersByName = new ArrayList<>();
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return usersByName;
            }
        }
        // for문 돌고 조건 맞는것이 없으면 밑에꺼는 무조건 실행됨.
        throw new UserNotFoundException(name + "의 번호는 없습니다.");
    }

    @Override
    public void updateUserEmail(int id, String email) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setEmail(email);
                user.setUpdatedAt(DateUtil.now());
            } else {
                throw new UserNotFoundException(id + "의 번호는 없습니다.");
            }
        }


    }

    @Override
    public void deleteUser(int id) {

        User deleteToUser = null;

        for (User user : userList) {
            if (user.getId() == id) {
                deleteToUser = user;
                break;
            } else {
                throw new UserNotFoundException(id + "의 번호는 없습니다.");
            }
        }
        userList.remove(deleteToUser);
    }
}
