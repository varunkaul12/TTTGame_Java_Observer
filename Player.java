public class Player {
	private String name = "No name";
	private String symbol = "";
	private Cell[] cell = new Cell[9];

	public Player(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
		for (int i = 0; i < 9; i++) {
			cell[i] = new Cell("");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Cell[] getCell() {
		return cell;
	}

	public void setCell(Cell[] cell) {
		this.cell = cell;
	}

	public void markCell(int index) {
		cell[index].setSymbol(symbol);
	}

	public void clearAll() {
		for (int i = 0; i < 9; i++) {
			cell[i].setSymbol("");
		}
	}

	public boolean amIaWinner() {
		// for(int i= 0;i<9;i++){
		// System.out.println("Cell : "+cell[i].getSymbol());
		// }
		boolean amI = false;
		if (cell[0].getSymbol().equals(this.symbol)
				&& cell[1].getSymbol().equals(this.symbol)
				&& cell[2].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[3].getSymbol().equals(this.symbol)
				&& cell[4].getSymbol().equals(this.symbol)
				&& cell[5].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[6].getSymbol().equals(this.symbol)
				&& cell[7].getSymbol().equals(this.symbol)
				&& cell[8].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[0].getSymbol().equals(this.symbol)
				&& cell[3].getSymbol().equals(this.symbol)
				&& cell[6].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[1].getSymbol().equals(this.symbol)
				&& cell[4].getSymbol().equals(this.symbol)
				&& cell[7].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[2].getSymbol().equals(this.symbol)
				&& cell[5].getSymbol().equals(this.symbol)
				&& cell[8].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[0].getSymbol().equals(this.symbol)
				&& cell[4].getSymbol().equals(this.symbol)
				&& cell[8].getSymbol().equals(this.symbol)) {
			amI = true;
		} else if (cell[2].getSymbol().equals(this.symbol)
				&& cell[4].getSymbol().equals(this.symbol)
				&& cell[6].getSymbol().equals(this.symbol)) {
			amI = true;
		}
		return amI;
	}
}
