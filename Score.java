import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String[] s = {"국어", "영어", "수학"};
        int[] scores = new int[s.length];

		
        for (int i = 0; i < s.length; i++) {
            while (true) {
                System.out.print(s[i] + " 점수 입력 (0~100): ");
                scores[i] = sc.nextInt();
                if (scores[i] >= 0 && scores[i] <= 100) {
                    break;
                } else {
                    System.out.println("0~100 사이의 점수만 입력하세요.");
                }
            }
        }
        int[] totalArr = new int[1];
        for (int score : scores) {
            totalArr[0] += score;
        }

        double avg = totalArr[0] / (double) scores.length;

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
        System.out.println("총점 : " + totalArr[0]);
        System.out.printf("평균 : %.2f\n", avg);
        System.out.println("학점 : " + grade);

        sc.close();
	}
	}


