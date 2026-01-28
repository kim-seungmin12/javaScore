import java.util.Scanner;

public class Score1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = { "국어", "영어", "수학" };
		int[][] scores = new int[3][s.length];

		for (int i = 0; i < 3; i++) {
			System.out.println( (i+1) + " 번째의 학생의 점수를 입력해주세요");
			for (int j = 0; j < s.length; j++) {
				while (true) {
					System.out.print(s[j] + " 점수 입력 (0~100): ");
					scores[i][j] = sc.nextInt();
					if (scores[i][j] >= 0 && scores[i][j] <= 100) {
						break;
					} else {
						System.out.println("0~100 사이의 점수만 입력하세요.");
					}
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			int total = 0;
			for (int j = 0; j < s.length; j++) {
				total += scores[i][j];
			}
			double avg = total / (double) scores.length;

			char grade;
			switch ((int) avg / 10) {
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			default:
				grade = 'F';
			}

			// 결과 출력
			System.out.println("\n===== 성적 결과 =====");
			System.out.println((i+1) + " 번째의 학생의 성적표");
			System.out.println("총점 : " + total);
			System.out.printf("평균 : %.2f\n", avg);
			System.out.println("학점 : " + grade);

			sc.close();
		}

	}
}
