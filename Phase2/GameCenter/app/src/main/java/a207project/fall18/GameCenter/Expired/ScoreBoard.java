//package a207project.fall18.GameCenter;
//
//import android.support.annotation.NonNull;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
///**
// * The ScoreBoard for a game and a user.
// * Each ScoreBoard contains the scores of one game for a user at a specific complexity.
// */
//
///**
// public abstract class ScoreBoard implements iterable
// */
//public abstract class ScoreBoard<T> implements Iterable<T> {
//
//    private List<T> list = new ArrayList<>();
//
//    ScoreBoard(List<Score> scores) {
//        Iterator<Score> iter = scores.iterator();
//
//    }
//
//
//    public void add(T object){
//        list.add(object);
//    }
//
//    ScoreBoard() {
//        List<Score> result = new ArrayList<>();
//        Collections.sort(result);
//        }
//
//
//
//
//    /**
//     * Scoreboard iterator
//     */
//    @NonNull
//    @Override
//    public Iterator<T> iterator() {
//        return new ScoreBoardIterator();
//    }
//
//    private class ScoreBoardIterator implements Iterator<T>{
//
//        private int next;
//
//        @Override
//        public boolean hasNext() {
//            return list.size() > next;
//        }
//
//        @Override
//        public T next() {
//            if(hasNext()) {
//                return list.get(next++);
//            }
//            throw new NoSuchElementException();
//        }
//    }
//}
