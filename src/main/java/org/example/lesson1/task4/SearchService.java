package org.example.lesson1.task4;

import java.util.List;

public interface SearchService {
    List<UserTask4> searchForFriendsInWidth(UserTask4 me, String name);
    List<UserTask4> searchForFriendsInDepth(UserTask4 me, String name);
}
