package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final String DELIMITER = ",";
    private static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto() {
        this(generateAutoLottoSets());
    }

    public Lotto(String lottoString) {
        this(generateManulalLottoSets(lottoString));
    }

    private Lotto(Set<LottoNumber> lottos) {
        validateSize(lottos);
        this.lottoNumbers = Collections.unmodifiableSet(lottos);
    }

    private static Set<LottoNumber> generateAutoLottoSets() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();

        while (lottoNumberSet.size() != LOTTO_SIZE) {
            lottoNumberSet.add(LottoNumber.peek());
        }
        return lottoNumberSet;
    }

    private static Set<LottoNumber> generateManulalLottoSets(String lottoString) {
        String[] lottoStrings = lottoString.split(DELIMITER);
        Set<LottoNumber> lottoNumberSet = new HashSet<>();

        for (String lottoNumber : lottoStrings) {
            lottoNumberSet.add(LottoNumber.valueOf(Integer.parseInt(lottoNumber.trim())));
        }
        return lottoNumberSet;
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> deduplicationLottoNumbers = new HashSet<>(lottoNumbers);
        if (deduplicationLottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개를 선택 해야합니다.", LOTTO_SIZE));
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isContainsLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
