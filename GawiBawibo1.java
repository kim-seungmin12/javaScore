
import javax.swing.JOptionPane;

public class GawiBawibo1 {

	private int win;
	private int lose;
	private int draw;
	private int total;

	public GawiBawibo1() {
		win = 0;
		lose = 0;
		draw = 0;
		total = 0;
	}

	private int parseUserInput(String input) {
		switch (input) {
		case "1":
		case "가위":
			return 1;
		case "2":
		case "바위":
			return 2;
		case "3":
		case "보":
			return 3;
		default:
			return -1;
		}
	}

	private String change(int n) {
		if (n == 1) return "가위";
		if (n == 2) return "바위";
		return "보";
	}

	private int getComVal() {
		return (int) (Math.random() * 3 + 1);
	}

	private String judge(int user, int com) {
		if (user == com) {
			draw++;
			return "무승부!";
		} else if (
			(user == 1 && com == 3) ||
			(user == 2 && com == 1) ||
			(user == 3 && com == 2)
		) {
			win++;
			return "당신 승리!";
		} else {
			lose++;
			return "컴 승리!";
		}
	}

	public void start() {
		while (true) {
			String input = JOptionPane.showInputDialog(
				"게임 시작!\n1 또는 가위\n2 또는 바위\n3 또는 보"
			);

			if (input == null) break;

			int user = parseUserInput(input.trim());
			if (user == -1) {
				JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
				continue;
			}

			int com = getComVal();
			total++;

			String result = "컴 : " + change(com) + ", 당신 : " + change(user) + "\n";
			result += judge(user, com);

			System.out.println(result);

			String cont = JOptionPane.showInputDialog("계속 할래요? (y / n)");
			if (cont == null || !cont.equals("y"))
				break;
		}

		printResult();
	}

	private void printResult() {
		if (total == 0) return;

		double rate = win * 100.0 / total;
		System.out.printf(
			"총 전적: %d\n승: %d\n패: %d\n무: %d\n승률: %.2f%%",
			total, win, lose, draw, rate
		);
	}

	public static void main(String[] args) {
		GawiBawibo1 game = new GawiBawibo1();
		game.start();
	}
}
