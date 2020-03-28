package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoShop {

    public List<Lotto> buyLotto(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = Math.floorDiv(price, 1000);

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

}
