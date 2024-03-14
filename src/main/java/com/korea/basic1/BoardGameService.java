package com.korea.basic1;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardGameService {

    private final BoardGameRepository boardGameRepository;

    public List<BoardGame> getAllBoardGames() {
        return boardGameRepository.findAll();
    }

    public void crawledData() {
        try {
            String url = "https://www.koreaboardgames.com/shop/big_section.php?cno1=1001";

            Document document = Jsoup.connect(url).get();
            Elements gameElements = document.select(".prd_basic .box");

            for (Element gameElement : gameElements) {
                BoardGame boardGame = new BoardGame();

                String title = gameElement.select(".name").text();

                    String img = gameElement.select(".prdimg img").attr("src");
                    boardGame.setImg(img);
                    boardGame.setTitle(title);

                    boardGameRepository.save(boardGame);
                }

            System.out.println("DB에 저장했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

