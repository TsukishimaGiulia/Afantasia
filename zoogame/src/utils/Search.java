package utils;

import model.item.Item;
import java.util.List;
import java.util.function.Predicate;

public class Search {

    private Search(){}

    public static <T> T byPredicate (List<T> list, Predicate<T> predicate){
        return list.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }
}
