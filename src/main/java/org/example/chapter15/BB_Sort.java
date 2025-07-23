package org.example.chapter15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
class News {
    private String title;
}

class NewsRepository {
    List<News> findTop3ByOrderByViewDesc() {
        return new ArrayList<>(List.of(
                new News("런닝맨 oo 하차 설.."),
                new News("놀면뭐하니 3주째 휴방..."),
                new News("스모킹건 PD 바뀐다고...?")
        ));
    }
}

class NewsService {
    NewsRepository newsRepository = new NewsRepository();
    private List<News> cachedPopularPosts;

    public List<News> getCachedPopularNews() {
        if (cachedPopularPosts == null) {
            cachedPopularPosts = new NewsRepository().findTop3ByOrderByViewDesc();
        }
        return cachedPopularPosts;
    }
}

public class BB_Sort {

}
