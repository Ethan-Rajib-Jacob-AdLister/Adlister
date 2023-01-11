//package com.codeup.adlister.dao;
//
////import com.codeup.adlister.models.Ad;
//import com.codeup.adlister.models.VGames;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ListVGamesDao implements Vgs{
//
//    private List<VGames> vGamesList;
//
//    public List<VGames> all() {
//        if (vGamesList == null) {
//            vGamesList = generateVGames();
//        }
//        return vGamesList;
//    }
//
//    @Override
//    public List<VGames> searchVGames(String title) throws Exception {
//        return null;
//    }
//
//    @Override
//    public List<VGames> searchMovies(String title) throws Exception {
//        return null;
//    }
//
//    public Long insert(VGames vGames) {
//        // make sure we have ads
//        if (vGamesList == null) {
//            vGamesList = generateVGames();
//        }
//        // we'll assign an "id" here based on the size of the ads list
//        // really the dao would handle this
//        vGames.setId((long) vGamesList.size());
//        vGamesList.add(vGames);
//        return vGames.getId();
//    }
//
//    private List<VGames> generateVGames() {
//        List<VGames> vGamesList = new ArrayList<>();
////        vGamesList.add(new VGames(
////                1,
////                1,
////                "playstation for sale",
////                "This is a slightly used playstation"
////        ));
////        vGamesList.add(new VGames(
////                2,
////                1,
////                "Super Nintendo",
////                "Get your game on with this old-school classic!"
////        ));
////        vGamesList.add(new VGames(
////                3,
////                2,
////                "Junior Java Developer Position",
////                "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
////        ));
////        vGamesList.add(new VGames(
////                4,
////                2,
////                "JavaScript Developer needed",
////                "Must have strong Java skills"
////        ));
//        return vGamesList;
//    }
//}
