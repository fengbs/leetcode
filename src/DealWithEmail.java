import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-7-18
 */
public class DealWithEmail {

	private static int num = 1;
	public void loadRawData( String path , String aimPath) throws IOException {
		List<String> list  = new ArrayList<>();
		File file = new File(path);
		if ( file.isDirectory() ) {
			File[] array = file.listFiles();
			if ( array != null ) {
				for ( File innerFile : array ) {
					//只处理带SUCCEEDED的文件。
					if(innerFile.getName().contains("SUCCEEDED")) {
						List<String> strList = readFile(innerFile);
						System.out.println(innerFile.getName());
						writeFile(aimPath,strList);
					}
				}
			}
		}
	}

	public List<String> readFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		List<String> resList = new ArrayList<>();
		String oneLine;
		boolean startFlag=false;
		boolean mergeFlag = false;
		String pre = "";
		while ( (oneLine = br.readLine()) != null ) {
			if ( startFlag ) {
				if ( mergeFlag ) {
					resList.add(pre.replace("=","") + oneLine.replace("=20",""));
					mergeFlag = false;
				} else if ( oneLine.startsWith("2018") || oneLine.startsWith("2019") ) {
					resList.add(oneLine.replace("=20",""));
				} else {
					break;
				}
			} else {
				if ( oneLine.contains("date") && oneLine.contains("ref")) {
					startFlag = true;
					if ( !oneLine.endsWith("=") ) {
						resList.add(oneLine.replace("=20", ""));
					} else {
						pre = oneLine;
						mergeFlag = true;
					}
				}
			}
		}
		return resList;
	}

	public void writeFile(String path,List<String> content) throws IOException {
		if ( content == null || content.size() ==0 ) {
			return;
		}
		if ( content.size() < 2 ) {
			System.out.println("yes");
		}
		String date = content.get(1).split(" ")[0];
		String filePath = path + "stdout_" + date + "_" + num;
		BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
		for ( String str : content ) {

			out.write(str.replace(" ","\t")+"\n");

		}
		out.close();
		++num;
	}

	public static void main ( String []args ) throws IOException {
		DealWithEmail dealWithEmail = new DealWithEmail();
		dealWithEmail.loadRawData("/home/fengbs/lideqing/ad_all/","/home/fengbs/lideqing/ad_all/result/");
	}
}
