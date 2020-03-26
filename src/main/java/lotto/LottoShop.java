package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoShop {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoShop() {
        IntStream.of(45)
                .forEach(value -> lottoNumbers.add(new LottoNumber(value)));
    }

    public List<Lotto> buyLotto(int price) {
        int lottoCount = Math.floorDiv(price, 1000);
        return null;
    }
}
