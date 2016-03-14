package designPattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class File {

	private File[] subFiles = { new File("a.txt"), new File("x.txt"),
			new File("c.txt"), new File("d.txt"), new File("e.txt") };

	private String name;

	File(String name) {
		this.name = name;
	}

	public File[] getSubFile() {
		return subFiles;
	}

	/**
	 * ����һ�����Զ��󣬺����ڲ����ò��Զ����ָ������������ҵ���߼�
	 * 
	 * @param stra
	 * @return
	 */
	public File[] getSubFile(Strategy stra) {
		List<File> subFileList = new ArrayList<File>();
		for (File subFile : subFiles) {
			if (stra.justify(subFile)) {
				subFileList.add(subFile);
			}
		}
		return subFileList.toArray(new File[subFileList.size()]);
	}

	public String getName() {
		return this.name;
	}

}
