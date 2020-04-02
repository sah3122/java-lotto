package lotto.domain;

import lotto.dto.LottoRequestDto;

import java.util.List;

public class Purchase {
    private static final int PRICE_PER_PIECE = 1000;
    private static final int ZERO = 0;

    private final int amount;
    private final int manualCount;
    private final List<String> lottoNumbers;

    public Purchase(LottoRequestDto lottoRequestDto) {
        validateAmount(lottoRequestDto.getAmount());
        amount = lottoRequestDto.getAmount();

        validateManuaulCount(lottoRequestDto.getManualCount());
        manualCount = lottoRequestDto.getManualCount();

        lottoNumbers = lottoRequestDto.getManualLottoStrings();
    }

    private void validateAmount(int price) {
        if (price < PRICE_PER_PIECE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    private void validateManuaulCount(int manualCount) {
        if (amount < manualLottoAmount(manualCount)) {
            throw new IllegalArgumentException("수동 구입 로또가 구입금액 보다 많습니다.");
        }
    }

    private int manualLottoAmount(int manualCount) {
        return PRICE_PER_PIECE * manualCount;
    }

    public int countOfAuto() {
        return lottoCount() - manualCount;
    }

    private int lottoCount() {
        return Math.floorDiv(amount, PRICE_PER_PIECE);
    }

    public boolean isManual() {
        return manualCount > ZERO;
    }

    public List<String> getLottoNumbers() {
        return lottoNumbers;
    }
}
