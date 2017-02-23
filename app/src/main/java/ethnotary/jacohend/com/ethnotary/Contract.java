package ethnotary.jacohend.com.ethnotary;

/**
 * Created by jacob on 2/17/17.
 */
public interface Contract {
    void add(String title, String address, String document);
    String getDoc(String title);
    long getTimestamp(String title);
}
