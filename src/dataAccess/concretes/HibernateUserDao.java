package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.List;

public class HibernateUserDao implements UserDao {

    @Override
    public void add(User user) {
        System.out.println("Kullanıcı hibernate ile eklendi: " + user.getFirstName());
    }

    @Override
    public void delete(User user) {
        System.out.println("Hesap bbaşarılı bir şekilde silinmiştir: " + user.getFirstName());
    }

    @Override
    public void update(User user) {
        System.out.println("Hesap güncellendi: " + user.getFirstName());
    }

    @Override
    public void getAll(List<User> users) {
        for (User user:users) {
            System.out.println(user.getFirstName());
        }
    }
}
