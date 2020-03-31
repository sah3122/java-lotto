package lotto;

import lotto.domain.LottoResult;
import lotto.dto.LottoRequestDto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        //int price = InputView.inputPrice();
        LottoRequestDto lottoRequestDto = InputView.inputParameters();
        LottoShop lottoShop = new LottoShop();

        lottoShop.buyLotto(lottoRequestDto);
        //lottoShop.buyAuto(price);
        ResultView.printLottoNumbers(lottoRequestDto, lottoShop.getLottoBundle());
        lottoRequestDto = InputView.inputLottoNumbers();
//        String winningNumber = InputView.inputWinningNumber();
//        int bonusNumber = InputView.inputBonusNumber();

        LottoResult lottoResult = lottoShop.checkWinning(lottoRequestDto);
        ResultView.printResult(lottoResult);
    }
}
