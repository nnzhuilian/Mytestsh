
public class MaskSeed {
	double cycle;
	int length;
	Data[] maskseeds;

	public MaskSeed(double cycle, int length) {
		this.cycle = cycle;
		this.length = length;
		maskseeds = new Data[length];
		for (int i=0;i<length;i++) {
			maskseeds[i]=new Data();
			maskseeds[i].setValue(i);
		}
	}
	public void SeedInitial(){
		for (Data maskseed : maskseeds) {
			double value=maskseed.getValue()-(cycle*(int)(maskseed.getValue()/cycle));
			if((0<=value)&&(value<=(cycle/4))){
				maskseed.setSymbol(1);
				maskseed.setCompare(0);
			}
			if(((cycle/4)<value)&&(value<=(cycle/2))){
				maskseed.setSymbol(-1);
				maskseed.setCompare(0);
			}
			if(((cycle/2)<value)&&(value<=(3*cycle/4))){
				maskseed.setSymbol(-1);
				maskseed.setCompare(1);
			}
			if(((3*cycle/4)<value)&&(value<=cycle)){
				maskseed.setSymbol(1);
				maskseed.setCompare(1);
			}
		}
	}
	public Data[] getMaskseeds() {
		SeedInitial();
		return maskseeds;
	}
	
	public String printmask(int windowsize){
		SeedInitial();
		MaskExtractor mask=new MaskExtractor(windowsize, maskseeds,length);
		String maskk=mask.getfeatureSequence();
		//String maskk=mask.getBandFeature();
		//System.out.println(maskk);
		System.out.println(" ");
		return maskk;
	}

}
