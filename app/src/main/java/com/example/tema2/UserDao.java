package com.example.tema2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    public List<User> getAll();
//
    @Query("DELETE FROM users WHERE name = (:userName)")
    public void deleteAllByNames(String userName);

//    @Query("SELECT * FROM user WHERE name LIKE :ﬁrst ")
//    User ﬁndByName(String ﬁrst, String last);

    @Insert
    public void addUser(User user);

    @Delete
    void deleteUser(User... user);
}
