import java.io.IOException;

public class DataInitial {
	Data[] datas;
	double[] dataMA;

	public DataInitial(double[] dataMA) {
		this.dataMA = dataMA;
	}

	public final Data[] getDatas() {
		dataInitial();
		setCompare();
		setSymbol();
		return datas;
	}

	void setSymbol() {// 判断是否大于0
		// TODO Auto-generated method stub
		for (int i = 0; i < dataMA.length - 1; i++) {
			if (datas[i].getValue() > 0) {
				datas[i].setSymbol(1);
			} else if (datas[i].getValue() < 0) {
				datas[i].setSymbol(-1);
			} else {
				datas[i].setSymbol(0);
			}
		}
	}

	void setCompare() {// 与前一个的比对
		// TODO Auto-generated method stub
		for (int i = 0; i < dataMA.length - 1; i++) {
			compareAandB(datas[i], datas[i + 1]);
		}
		datas[0].setCompare(1);
	}

	void dataInitial() {
		int l = dataMA.length;
		datas = new Data[l];
		for (int i = 0; i < l; i++) {
			datas[i] = new Data();
			datas[i].setValue(dataMA[i]);
		}
	}

	public void compareAandB(Data a, Data b) {
		if (a.getValue() > b.getValue()) {
			b.setCompare(0);
		} else {
			b.setCompare(1);
		}
	}
	
}
