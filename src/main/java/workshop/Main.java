import io.reactivex.Flowable;

public class Main {

    public static void main(String[] args) {
        Flowable.just("Hello world")
                .subscribe(System.out::println);
    }
}
