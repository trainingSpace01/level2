package org.example.lesson1.task4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SearchServiceTest {
    @Test
    public void test1() {
        UserTask4 vasilii = new UserTask4("Василий");
        UserTask4 arina = new UserTask4("Арина");
        UserTask4 yulya = new UserTask4("Юля");
        UserTask4 evgenii = new UserTask4("Евгений");
        UserTask4 konstantin = new UserTask4("Константин");
        UserTask4 vladimir = new UserTask4("Владимир");
        UserTask4 mariya = new UserTask4("Мария");
        UserTask4 dmitrii = new UserTask4("Дмитрий");
        UserTask4 anatolii = new UserTask4("Анатолий");
        UserTask4 gennadii = new UserTask4("Геннадий");
        UserTask4 anna = new UserTask4("Анна");
        UserTask4 mikhail = new UserTask4("Михаил");
        UserTask4 sergei = new UserTask4("Сергей");
        UserTask4 natasha = new UserTask4("Наташа");
        vasilii.setFriends(Arrays.asList(arina, yulya));
        arina.setFriends(Arrays.asList(vasilii, dmitrii));
        yulya.setFriends(Arrays.asList(vasilii, konstantin, evgenii));
        evgenii.setFriends(Arrays.asList(yulya, natasha));
        konstantin.setFriends(Arrays.asList(yulya, vladimir, mariya, natasha));
        vladimir.setFriends(Arrays.asList(konstantin, mariya));
        mariya.setFriends(Arrays.asList(konstantin, vladimir));
        dmitrii.setFriends(Arrays.asList(arina, anatolii, sergei));
        anatolii.setFriends(Arrays.asList(dmitrii, gennadii, mikhail));
        gennadii.setFriends(Arrays.asList(anatolii, anna));
        anna.setFriends(Arrays.asList(gennadii, mikhail));
        mikhail.setFriends(Arrays.asList(anatolii, sergei, anna, natasha));
        sergei.setFriends(Arrays.asList(dmitrii, mikhail));
        natasha.setFriends(Arrays.asList(konstantin, evgenii, mikhail));

        SearchService service = new SearchServiceImpl();

        List<UserTask4> foundFriends = service.searchForFriendsInDepth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
        foundFriends = service.searchForFriendsInWidth(vasilii, "Наташа");
        //System.out.println(foundFriends.contains(natasha));
        Assert.assertTrue(foundFriends.contains(natasha));
    }

    @Test
    public void test2() {
        UserTask4 vasilii = new UserTask4("Василий");
        UserTask4 arina = new UserTask4("Арина");
        UserTask4 yulya = new UserTask4("Юля");
        UserTask4 evgenii = new UserTask4("Евгений");
        UserTask4 konstantin = new UserTask4("Константин");
        UserTask4 vladimir = new UserTask4("Владимир");
        UserTask4 mariya = new UserTask4("Мария");
        UserTask4 dmitrii = new UserTask4("Дмитрий");
        UserTask4 anatolii = new UserTask4("Анатолий");
        UserTask4 gennadii = new UserTask4("Геннадий");
        UserTask4 anna = new UserTask4("Анна");
        UserTask4 mikhail = new UserTask4("Михаил");
        UserTask4 sergei = new UserTask4("Сергей");
        UserTask4 natasha = new UserTask4("Наташа");
        UserTask4 natasha2 = new UserTask4("Наташа");
        vasilii.setFriends(Arrays.asList(arina, yulya));
        arina.setFriends(Arrays.asList(vasilii, dmitrii, natasha2));
        yulya.setFriends(Arrays.asList(vasilii, evgenii));
        evgenii.setFriends(Arrays.asList(yulya));
        konstantin.setFriends(Arrays.asList(vladimir, mariya));
        vladimir.setFriends(Arrays.asList(konstantin));
        mariya.setFriends(Arrays.asList(konstantin, vasilii));
        dmitrii.setFriends(Arrays.asList(arina, anatolii, natasha));
        anatolii.setFriends(Arrays.asList(dmitrii, gennadii));
        gennadii.setFriends(Arrays.asList(anatolii));
        anna.setFriends(Arrays.asList(mikhail));
        mikhail.setFriends(Arrays.asList(sergei, anna));
        sergei.setFriends(Arrays.asList(natasha, mikhail));
        natasha.setFriends(Arrays.asList(dmitrii, sergei));
        natasha2.setFriends(Arrays.asList(arina));

        SearchService service = new SearchServiceImpl();

        List<UserTask4> foundFriends = service.searchForFriendsInDepth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
        Assert.assertTrue(foundFriends.contains(natasha2));
        foundFriends = service.searchForFriendsInWidth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
        Assert.assertTrue(foundFriends.contains(natasha2));
    }

    @Test
    public void test3() {
        UserTask4 vasilii = new UserTask4("Василий");
        UserTask4 arina = new UserTask4("Арина");
        UserTask4 mariya = new UserTask4("Мария");
        UserTask4 vladimir = new UserTask4("Владимир");
        UserTask4 evgenii = new UserTask4("Евгений");
        UserTask4 yulya = new UserTask4("Юля");
        UserTask4 konstantin = new UserTask4("Константин");
        UserTask4 dmitrii = new UserTask4("Дмитрий");
        UserTask4 natasha = new UserTask4("Наташа");
        vasilii.setFriends(Arrays.asList(arina, mariya, vladimir, evgenii));
        arina.setFriends(Arrays.asList(vasilii, dmitrii, vasilii));
        yulya.setFriends(Arrays.asList(konstantin, evgenii, vladimir, dmitrii));
        evgenii.setFriends(Arrays.asList(yulya, vasilii, dmitrii));
        konstantin.setFriends(Arrays.asList(vladimir, mariya, yulya, natasha));
        vladimir.setFriends(Arrays.asList(konstantin, vasilii, yulya));
        mariya.setFriends(Arrays.asList(konstantin, vasilii, natasha));
        dmitrii.setFriends(Arrays.asList(arina, evgenii, natasha, yulya));
        natasha.setFriends(Arrays.asList(dmitrii, arina, konstantin, mariya));
        SearchService service = new SearchServiceImpl();
        List<UserTask4> foundFriends = service.searchForFriendsInDepth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
        foundFriends = service.searchForFriendsInWidth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
    }
}
