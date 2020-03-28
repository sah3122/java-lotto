package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();

        while (lottoNumberSet.size() != 6) {
            lottoNumberSet.add(LottoNumber.peek());
        }

        List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNumberSet).stream()
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .collect(Collectors.toList());

        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public Lotto(String[] lottoStrings) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();

        for (String lottoNumber : lottoStrings) {
            lottoNumberSet.add(LottoNumber.valueOf(Integer.parseInt(lottoNumber.trim())));
        }

        List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNumberSet).stream()
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .collect(Collectors.toList());

        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> duDeduplicationLottoNumbers = new HashSet<>(lottoNumbers);
        if (duDeduplicationLottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
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
