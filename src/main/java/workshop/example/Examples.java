package workshop.example;

import io.reactivex.Completable;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Examples {

    public static void main(String[] args) {
        just();
    }

    private static Observable<String> just() {
        return Observable.just("Hello", "world", "!");
    }

    private static Observable<String> fromIteratable() {
        List<String> words = Arrays.asList("Hello", "world", "!");
        return Observable.fromIterable(words);
    }

    private static Observable<Long> interval() {
        return Observable.interval(1, TimeUnit.SECONDS)
                .take(5);
    }

    private static Observable<String> timer() {
        return Observable.timer(5, TimeUnit.SECONDS)
                .map(i -> "Timeout!");
    }

    private static void flatMap() {
        final Observable<String> letters = Observable.just("a", "b", "c");

        Observable.just(1, 2, 3)
                .flatMap(integer -> letters)
                .subscribe(string -> {
                    // Do something
                });
    }
}
