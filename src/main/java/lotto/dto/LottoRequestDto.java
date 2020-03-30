package lotto.dto;

import java.util.List;

public class LottoRequestDto {
    private int price;
    private int manualCount;
    private List<String> manualLottoStrings;

    public LottoRequestDto(int price, int manualCount, List<String> manualLottoStrings) {
        this.price = price;
        this.manualCount = manualCount;
        this.manualLottoStrings = manualLottoStrings;
    }

    public int getPrice() {
        return price;
    }

    public int getManualCount() {
        return manualCount;
    }

    public List<String> getManualLottoStrings() {
        return manualLottoStrings;
    }
}
