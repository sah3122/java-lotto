package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoShop = new LottoShop();
    }

    @DisplayName("구입 금액에 맞게 로또 생성")
    @Test
    void createLotto(int price) {
        List<Lotto> lottos = lottoShop.buyLotto(price);

        assertThat(lottos).hasSize(price/1000);
    }

    @DisplayName("당첨 로또 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void checkWinning(String winningLottoNumbers) {
        Lotto winningLotto = lottoShop.createLotto(winningLottoNumbers);
        assertThat(winningLotto.getLottoNumbers()).containsExactly(winningLottoNumbers.split(","));
    }

    @DisplayName("당첨 확인")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 6:6"}, delimiter = ':')
    void checkWinning(String buyingNumber, String winningLottoNumbers, int expected) {
        Lotto buyingLotto = lottoShop.createLotto(buyingNumber);
        Lotto winningLotto = lottoShop.createLotto(winningLottoNumbers);
        assertThat(lottoShop.checkWinning(buyingLotto, winningLotto)).isEqaul(expected);
    }
}
