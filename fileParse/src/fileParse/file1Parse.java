package fileParse;

import java.io.*;

public class file1Parse {

	public static void convertToCSV(String Infname, int[] fieldLens, String headers){
		String Outfname = Infname.split(".txt")[0]+".csv";
		int i,j,startInd;
		String line,lineFrag;
		try {
			FileReader file = new FileReader(Infname);
			BufferedReader bread = new BufferedReader(file);
			FileWriter outFile = new FileWriter(Outfname);
			BufferedWriter bwrite = new BufferedWriter(outFile);
			bwrite.write(headers+"\n");
			while((line = bread.readLine())!=null){//for(i=0;i<6;i++){line = bread.readLine();
				int strLen = line.length();
				startInd=0;
				for(j=0;j<fieldLens.length;j++){
					lineFrag = line.substring(startInd, startInd+fieldLens[j])+",";
					bwrite.write(lineFrag);
					//System.out.print(lineFrag);
					startInd+=fieldLens[j];	
				}
				bwrite.write("\n");
				//System.out.println();
			}
			bread.close(); bwrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*public static void parseFields(String fname){
		String line, totLine;
		int startInd, endInd, startFlag, endFlag;
		try {
			FileReader file = new FileReader(fname);
			BufferedReader bread = new BufferedReader(file);
			while((line = bread.readLine())!=null){//for(i=0;i<6;i++){
				startFlag = 0;
				for(int i=0;i<line.length();i++){
					if(Character.isAlphabetic(line.charAt(i)) &&  startFlag !=1){
						startFlag = 1;
						startInd = i+2;
					}
					if(Char)
				}
				line = bread.readLine();
				int strLen = line.length();
			}
			bread.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public static void main(String[] args) {
		int[] f1Lens = {5,17,1,10,4,4,6,11,11,11,11,11,11};
		String f1Heads = "Lender Number,Lender Loan Number,Delinquent Flag,Account Number,Tax Year,Year For,Billing Type,Real Property Value,Total Personal Value,Principal Due (xxxxxxxx.xx),Interest Due,Cost Due,Total Due";
		convertToCSV("REAL_ESTATE_FULL113_08122016.txt", f1Lens, f1Heads);
		
		int[] f2Lens = {8,10,4,4,6,3,40,2,8,13,13,3,3,3,2,7,8,6,10,3,8,2,60,60,35,40,35,35,35,2,6,25,4,2,5,2,6,6,5,8,10,10,3,1,1,1,3,11,5,6,5,5,11,11,8,12,11,11,11,11,11,12,12,12,7,12,12,12,12,7,12,12,12,12,12};
		String f2Heads = "Tape Creation Date (mmddyyyy),Account Number,Tax Year,Year For,Billing Type,Account Type,Description,Billing Class,Billing Date (mmddyyyy),City,Fire District,Special District 1,Special District 2,Special District 3,Township,Real Estate ID (REID),Acres (xxxxx.xx),Map Name,PIN Number,PIN Extension,Annexation Date (mmddyyyy),Annexation Fire,Primary Owner (Last, First, Mid, Sfx, Ext),Secondary Owner (Last, First, Mid, Sfx, Ext),C/O,Trade Name,Mailing Address 1 (primary owner ),Mailing Address 2 (primary owner),Mailing Address 3 (primary owner),Street Prefix,Street Number,Street Name,Street Type,Street Suffix,Zip Code,Planning Jurisdiction,NAICS Code,Deed Book,Deed Page,Deed Date (mmddyyyy),History ID1,History ID2,Exempt Status Code,Tax Relief Code,Historic Deferred Code,Land Deferred Code,Late List Percent,Late List Value,Number Recycle Units,Recycle Fee Per Unit (xxx.xx),Number Vehicle City Tag,Vehicle Fee Per Tag (xx.xx),Building Value,Land Value,Tobacco Value,Tax Relief Value,Historic Deferred Value,Land Deferred Value,Total Real Value,Total Personal Value,Net Billable Value,City Property Tax Billed (xxxxxxxxx.xx),City Special Distr Tax Billed (xxxxxxxxx.xx),City Late List Billed (xxxxxxxxx.xx),City Veh Fee Billed (xxxx.xx),County Property Tax Billed (xxxxxxxxx.xx),County Fire Distr Tax Billed (xxxxxxxxx.xx),County Spec Distr Tax Billed (xxxxxxxxx.xx),County Late List Billed (xxxxxxxxx.xx),County Recycle Fee Billed (xxxx.xx),Total Billed (xxxxxxxxx.xx),Total Principal Due (xxxxxxxxx.xx),Interest Due,Cost Due,Total Due";
		convertToCSV("REAL_ESTATE_FULL853_08122016.txt",f2Lens,f2Heads);
	}

}
