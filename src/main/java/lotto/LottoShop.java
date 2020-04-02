package lotto;

import lotto.domain.*;
import lotto.dto.LottoRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoShop {
    private LottoBundle lottoBundle;

    public LottoShop() {
    }

    public LottoShop(LottoBundle lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public void buyLotto(LottoRequestDto lottoRequestDto) {
        Purchase purchase = new Purchase(lottoRequestDto);

        lottoBundle = buy(purchase);
    }

    private LottoBundle buy(Purchase purchase) {
        LottoBundle lottoBundle = buyAuto(purchase.countOfAuto());
        if (purchase.isManual()) {
            return lottoBundle.join(buyManual(purchase.getLottoNumbers()));
        }
        return lottoBundle;
    }

    public LottoBundle buyAuto(int lottoCount) {
        return new LottoBundle(toLottos(lottoCount));
    }

    public LottoBundle buyManual(List<String> lottoStrings) {
        return lottoStrings.stream()
                .map(Lotto::manual)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoBundle::new));
    }

    private List<Lotto> toLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.auto());
        }
        return lottos;
    }

    public LottoResult checkWinning(LottoRequestDto lottoRequestDto) {
        List<WinningType> winningTypes = lottoBundle.drawForWinning(lottoRequestDto.getWinningNumber(), lottoRequestDto.getBonusNumber());
        return new LottoResult(winningTypes, lottoBundle.size());
    }

    public LottoBundle getLottoBundle() {
        return lottoBundle;
    }
}
