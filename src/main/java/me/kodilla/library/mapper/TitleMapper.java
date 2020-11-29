package me.kodilla.library.mapper;

import me.kodilla.library.domain.Title;
import me.kodilla.library.domain.dto.TitleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleMapper {
    public Title mapToTitle(TitleDto o) {
        return new Title(
                o.getId(),
                o.getTitle(),
                o.getAuthor(),
                o.getReleaseDate()
        );
    }

    public TitleDto mapToTitleDto(Title o) {
        return new TitleDto(
                o.getId(),
                o.getTitle(),
                o.getAuthor(),
                o.getReleaseDate()
        );
    }

    public List<TitleDto> mapToTitleDtoList(List<Title> titles) {
        return titles.stream()
                .map(this::mapToTitleDto)
                .collect(Collectors.toList());
    }
}
