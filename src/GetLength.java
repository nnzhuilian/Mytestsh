
public class GetLength {
	int cyclesNum = 0;
	Data[] datas;//�ӳ�ʼ��������������ݡ�


	public GetLength(Data[] datas,int cyclesNum) {
		this.cyclesNum = cyclesNum;
		this.datas=datas;
	}

	public int getBitLength() {//����Ҫȡ��bit����
		int i = 0;
		boolean flag = true;// ǰһ�����ţ�trueΪ����flaseΪ��
		for (int j = 0;; j++) {
			if (datas[j].symbol > 0 && flag == true) {

			}
			if (datas[j].symbol <= 0 && flag == true) {// �������������˳�
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
