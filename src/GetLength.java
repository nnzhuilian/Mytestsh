
public class GetLength {
	int cyclesNum = 0;
	Data[] datas;//从初始化器里读出的数据。


	public GetLength(Data[] datas,int cyclesNum) {
		this.cyclesNum = cyclesNum;
		this.datas=datas;
	}

	public int getBitLength() {//返回要取的bit数。
		int i = 0;
		boolean flag = true;// 前一个符号，true为正，flase为负
		for (int j = 0;; j++) {
			if (datas[j].symbol > 0 && flag == true) {

			}
			if (datas[j].symbol <= 0 && flag == true) {// 到达周期数，退出
				flag = false;
				i++;
				if (i == cyclesNum + 1) {
					return j+1;
				}
			}
			if (datas[j].symbol > 0 && flag == false) {
				flag = true;
			}
			if (datas[j].symbol <= 0 && flag == false) {

			}
		}
	}
	
}
