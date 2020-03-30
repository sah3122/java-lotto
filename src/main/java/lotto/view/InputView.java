package lotto.view;

import lotto.dto.LottoRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputView {
    private static final int PRICE_PER_PIECE = 1000;
    private static final Scanner scanner = new Scanner(System.in);

    public static LottoRequestDto inputParameters() {
        int price = inputPrice();
        int manualCount = inputManualCount();
        List<String> manualLottoStrings = inputManualLottoStrings(manualCount);

        return new LottoRequestDto(price, manualCount, manualLottoStrings);
    }

    private static int inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int price = scanner.nextInt();
        System.out.println(String.format("%d개를 구매 했습니다.", price / PRICE_PER_PIECE));
        return price;
    }

    private static int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    private static List<String> inputManualLottoStrings(int manualCount) {
        System.out.println("수동으로 구매할 로또 번호를 입력해 주세요.");
        List<String> manualLottoStrings = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottoStrings.add(scanner.next());
        }
        return manualLottoStrings;
    }


    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
