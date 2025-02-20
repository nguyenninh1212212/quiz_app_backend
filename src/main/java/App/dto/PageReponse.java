package App.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
@AllArgsConstructor
@Builder
public class PageReponse<T> {
    private List<T> data;
    private int page;
    private int limit;
    private int total;
}
