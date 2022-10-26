package onboarding;

import static onboarding.Problem1.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

class Problem1Test {

	@Nested
	class getMaxDigitTest {

		@Test
		@DisplayName("정수의 각 자리 수 합을 반환해야 한다")
		public void getMaxDigitSumTest() {
			// given
			List<Integer> pageList = new ArrayList<>();
			pageList.add(123);
			pageList.add(124);

			// when
			int maxDigitSum = getMaxDigitSum(pageList);

			// then
			assertThat(maxDigitSum).isEqualTo(1+2+4);
		}

		@Test
		@DisplayName("정수의 각 자리 수 곱을 반환해야 한다")
		public void getMaxDigitProductTest() {
			// given
			List<Integer> pageList = new ArrayList<>();
			pageList.add(129);
			pageList.add(130);

			// when
			int maxDigitProduct = getMaxDigitProduct(pageList);

			// then
			assertThat(maxDigitProduct).isEqualTo(1*2*9);
		}
	}

	@Nested
	class getScoreTest {

		@Test
		@DisplayName("곱한 값이 더 큰 경우 곱한 값을 반환해야 한다")
		public void getScoreTest1() {
			List<Integer> pageList = new ArrayList<>();
			pageList.add(357);
			pageList.add(358);

			int score = getScore(pageList);
			assertThat(score).isEqualTo(120);
		}
		@Test
		@DisplayName("더한 값이 더 큰 경우 더한 값을 반환해야 한다")
		public void getScoreTest2() {
			List<Integer> pageList = new ArrayList<>();
			pageList.add(19);
			pageList.add(20);

			int score = getScore(pageList);
			assertThat(score).isEqualTo(10);
		}
	}

	@Nested
	class getWinnerTest {

		@Test
		public void drawTest1() {
			List<Integer> pobi = new ArrayList<>();
			pobi.add(199);
			pobi.add(200);

			List<Integer> crong = new ArrayList<>();
			crong.add(99);
			crong.add(100);

			int winner = getWinner(pobi, crong);
			assertThat(winner).isEqualTo(0);
		}

		@Test
		public void drawTest2() {
			List<Integer> pobi = new ArrayList<>();
			pobi.add(199);
			pobi.add(200);

			List<Integer> crong = new ArrayList<>();
			crong.add(199);
			crong.add(200);

			int winner = getWinner(pobi, crong);
			assertThat(winner).isEqualTo(0);
		}

		@Test
		public void pobiWinTest() {
			List<Integer> pobi = new ArrayList<>();
			pobi.add(17);
			pobi.add(18);

			List<Integer> crong = new ArrayList<>();
			crong.add(15);
			crong.add(16);

			int winner = getWinner(pobi, crong);
			assertThat(winner).isEqualTo(1);
		}

		@Test
		public void crongWinTest() {
			List<Integer> pobi = new ArrayList<>();
			pobi.add(395);
			pobi.add(396);

			List<Integer> crong = new ArrayList<>();
			crong.add(397);
			crong.add(398);

			int winner = getWinner(pobi, crong);
			assertThat(winner).isEqualTo(2);
		}
	}

	@Nested
	class exceptionHandlingTest {

		@Test
		public void checkPageHasAscending1DifferenceTest() {
			List<Integer> pageList = new ArrayList<>();
			pageList.add(234);
			pageList.add(233);

			assertThrows(IllegalStateException.class, () -> {
				checkPageHasAscending1Difference(pageList);
			});
		}

		@Test
		public void checkListInGivenRangeTest1() {
			List<Integer> pageList = new ArrayList<>();
			pageList.add(0);
			pageList.add(1);

			assertThrows(IllegalStateException.class, () -> {
				checkListInGivenRange(pageList);
			});
		}

		@Test
		public void checkListInGivenRangeTest2() {
			List<Integer> pageList = new ArrayList<>();
			pageList.add(399);
			pageList.add(400);

			assertThrows(IllegalStateException.class, () -> {
				checkListInGivenRange(pageList);
			});
		}
	}
}
