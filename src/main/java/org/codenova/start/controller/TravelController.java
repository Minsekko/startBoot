package org.codenova.start.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.codenova.start.entity.TravelComment;
import org.codenova.start.model.travel.TravelWarning;
import org.codenova.start.repository.TravelRepository;
import org.codenova.start.service.TravelWarningAPIService;
import org.codenova.start.vo.TravelComments;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/travel")
public class TravelController {

    private final TravelRepository travelRepository;
    private TravelWarningAPIService travelWarningAPIService;

    @GetMapping("/warning")
    public String warningHandle(@RequestParam("p") Optional<Integer> p, Model model) throws JsonProcessingException {

        int pValue = p.orElse(1);

        TravelWarning[] warnings = travelWarningAPIService.findAll(pValue);

        model.addAttribute("travelWarnings", warnings);


        return "travel/warning";
    }

    @GetMapping("/warning/detail")
    public String warningDetailHandel(@RequestParam("isoCode") String isoCode, Model model) throws JsonProcessingException {
        System.out.println("param=" + isoCode);

        TravelWarning warning = travelWarningAPIService.findByIsoCode(isoCode);

        model.addAttribute("data", warning);

        List<TravelComment> comment = travelRepository.findByIsoCode(isoCode);
        List<TravelComments> comments = new ArrayList<>();
        PrettyTime prettyTime = new PrettyTime();

        for (TravelComment TravelComment : comment) {
            TravelComments cvt = TravelComments.builder()
                    .id(TravelComment.getId())
                    .isoCode(TravelComment.getIsoCode())
                    .body(TravelComment.getBody())
                    .time(prettyTime.format(TravelComment.getWritedAt()))
                    .build();
            comments.add(cvt);
            System.out.println(prettyTime.format(TravelComment.getWritedAt()));
        }
        model.addAttribute("comments", comments);

        model.addAttribute("result", travelRepository.findCountByIsoCode(isoCode));

        return "travel/warning/detail";
    }

    @GetMapping("/comment-create")
    public String travelCreateHandel(TravelComment travelComment, Model model) throws  JsonProcessingException {

        travelRepository.create(travelComment);

        return "redirect:/travel/warning/detail?isoCode="+travelComment.getIsoCode();
    }

}
