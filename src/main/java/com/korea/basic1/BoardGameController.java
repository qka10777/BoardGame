package com.korea.basic1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardGameController {

    private final BoardGameService boardGameService;

    @GetMapping("/")
    public String mainPage(Model model) {
        return "main_page";
    }

    @GetMapping("/list")
    public String getAllBoardGames(Model model) {
        List<BoardGame> boardGameList = boardGameService.getAllBoardGames();
        model.addAttribute("boardGames", boardGameList);
        return "board_games";
    }

    @GetMapping("/crawlAndSave")
    public String crawlAndSave(Model model) {
        boardGameService.crawledData();
        return "redirect:/list";
    }

}
