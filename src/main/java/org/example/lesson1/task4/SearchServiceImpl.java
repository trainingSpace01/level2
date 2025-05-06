package org.example.lesson1.task4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchServiceImpl implements SearchService{
    @Override
    public List<UserTask4> searchForFriendsInWidth(UserTask4 me, String name) {
        List<UserTask4> natashasList = new ArrayList<>();
        ArrayList<Long> visitedIDs = new ArrayList<>();
        Queue<UserTask4> q = new LinkedList<>();
        q.add(me);
        while (!q.isEmpty()) {
            UserTask4 user = q.remove();
            ArrayList<UserTask4> childs = null;
            while (!(childs = (ArrayList<UserTask4>) chekcUnvisitedChilds(user.getFriends(), visitedIDs)).isEmpty()) {
                childs.stream().forEach(c -> {
                    visitedIDs.add(c.getId());
                    //if(c.getName().equals(name))
                        natashasList.add(c);
                    q.add(c);
                });
            }
        }
        return natashasList;
    }

    @Override
    public List<UserTask4> searchForFriendsInDepth(UserTask4 me, String name) {
        List<UserTask4> natashasList = new ArrayList<>();
        ArrayList<Long> visitedIDs = new ArrayList<>();
        Stack<UserTask4> s = new Stack<>();
        s.push(me);
        while (!s.isEmpty()) {
            UserTask4 user = s.peek();
            ArrayList<UserTask4> childs = (ArrayList<UserTask4>) chekcUnvisitedChilds(user.getFriends(), visitedIDs);
            if (!childs.isEmpty()) {
                childs.stream().forEach(c -> {
                    visitedIDs.add(c.getId());
                    //if(c.getName().equals(name))
                        natashasList.add(c);
                    s.push(c);
                });
            } else {
                s.pop();
            }
        }
        return natashasList;
    }

    public List<UserTask4> chekcUnvisitedChilds (List<UserTask4> friends, ArrayList<Long> visitedIDs) {
       return  friends.stream().filter(f -> !visitedIDs.contains(f.getId())).collect(Collectors.toList());
    }
}
