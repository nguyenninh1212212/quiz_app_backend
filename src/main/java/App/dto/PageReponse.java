package App.dto;

import java.util.List;

public class PageReponse<T> {
    private List<T> data;
    private int page;
    private int limit;
}
