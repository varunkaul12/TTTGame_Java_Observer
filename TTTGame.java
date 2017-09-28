import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TTTGame extends JApplet {
	int currentPlayer = 0;
	Player[] players = new Player[2];
	JPanel topPanel = new JPanel();
	JPanel boardPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JLabel turnLabel = new JLabel();
	JButton startButton = new JButton();
	TTTButton[] cellButton = new TTTButton[9];

	@Override
	public void init() {
		players[0] = new Player("Varun", "X");
		players[1] = new Player("Jon Doe", "O");
		resize(250, 430);
		topPanel.setPreferredSize(new Dimension(250, 90));
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		topPanel.add(turnLabel);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		bottomPanel.setPreferredSize(new Dimension(250, 90));
		startButton.setText("Start");
		startButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				JButton button = (JButton) e.getSource();

				if (button.getText().equals("Start"))
					for (int i = 0; i < 9; i++) {
						cellButton[i].setEnabled(true);
						turnLabel.setText(("It is " + players[0].getName() + " s turn"));
					}
				else if (button.getText().equals("Re-start")) {
					players[0].clearAll();
					players[1].clearAll();
					for (int i = 0; i < 9; i++) {
						cellButton[i].setEnabled(true);
						cellButton[i].setText(" ");
					}
				}

			}
		});

		bottomPanel.add(startButton);
		boardPanel.setLayout(new GridLayout(3, 3, 10, 10));
		for (int i = 0; i < cellButton.length; i++) {
			cellButton[i] = new TTTButton(i);
			boardPanel.add(cellButton[i]);
			cellButton[i].setEnabled(false);
			cellButton[i].addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@SuppressWarnings("deprecation")
				@Override
				public void mouseClicked(MouseEvent e) {
					TTTButton button = (TTTButton) e.getSource();
					if (button.isEnabled()) {
						players[currentPlayer].markCell(button.index);
						button.setLabel(players[currentPlayer].getSymbol());
						button.setEnabled(false);
						if (players[currentPlayer].amIaWinner()) {
							turnLabel.setText(players[currentPlayer].getName()
									+ " Wins!!!");
							for (int i = 0; i < 9; i++) {
								cellButton[i].setEnabled(false);
							}
							startButton.setText("Re-start");
						} else {
							currentPlayer = currentPlayer == 1 ? 0 : 1;
							turnLabel.setText(("It is "+ players[currentPlayer].getName() + " s turn"));
						}
					}

				}
			});
		}
		this.setLayout(new BorderLayout(10, 10));
		this.getContentPane().add(topPanel, BorderLayout.NORTH);
		this.getContentPane().add(boardPanel, BorderLayout.CENTER);
		this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
	}
}
