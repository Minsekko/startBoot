package org.codenova.start.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.codenova.start.entity.TravelComment;
import org.codenova.start.model.animal.AbandonmentJSON;
import org.codenova.start.model.animal.Item;
import org.codenova.start.model.travel.Items;
import org.codenova.start.model.travel.TravelJSON;
import org.codenova.start.model.travel.TravelWarning;
import org.codenova.start.repository.TravelRepository;
import org.codenova.start.service.TravelWarningAPIService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

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

        return "travel/warning/detail";
    }

    @GetMapping("/comment-create")
    public String travelCreateHandel(TravelComment travelComment, Model model) throws  JsonProcessingException {

        travelRepository.create(travelComment);

        return "redirect:/travel/warning/detail?isoCode="+travelComment.getIsoCode();
    }

}
